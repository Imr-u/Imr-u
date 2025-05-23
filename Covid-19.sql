--check if the data's are correctly imported
select * 
from CovidDeaths;

select * 
from CovidVaccinations;
--select the data's that we mainly going to be working with and start from death tabels 
-- and then to vaccianation

select location, date,total_cases, total_deaths, population 
from CovidDeaths
order by 1 ;

------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------

 -- see if the lock down really decreased the death rate or not. take march 2020 as average lockdown for the world
 -- try to find the death rate based on the continents
 -- before the lock down from the data

with befor_lock as (
 select continent, round(avg((total_deaths/population)* 100),6) as death_rate_before_lock_down
from CovidDeaths 
where population != 0 and continent != '' and date <= '2/15/2020'
group by continent
)
select * into #temp_befor
from befor_lock;
		

 -- at the start of the lock down

with lock_start as (
select continent, round(avg((total_deaths/population)* 100),6) as death_rate_start_of_lock_down
from CovidDeaths 
where population != 0 and continent != '' and date between '2/15/2020' and '5/0/2020'
group by continent)

select * into #temp_start
from lock_start;

-- when the lock down was strict

with lock_strict as(
select continent, round(avg((total_deaths/population)* 100),6) as death_rate_peack_of_lock_down
from CovidDeaths 
where population != 0 and continent != '' and date between '5/1/2020' and '9/1/2020'
group by continent)

select * into #temp_strict
from lock_strict;

-- when the lock down become loose and peoples start coming out 


with lock_loose as (
select continent, round(avg((total_deaths/population)* 100),6) as death_rate_ease_of_lock_down
from CovidDeaths 
where population != 0 and continent != '' and date between  '12/1/2020'  and '9/1/2020' 
group by continent
)

select * into #temp_lose
from lock_loose;



-- when the vaccination star
  
with after_vaccination as(
select continent, round(avg((total_deaths/population)* 100),6) as death_rate_from_vaccination
from CovidDeaths 
where population != 0 and continent != '' and date >= '5/1/2021'
group by continent
)

select * into #temp_vacc
from after_vaccination


-- joining the temp tables created and creating one summary table

select b.continent, death_rate_before_lock_down, death_rate_start_of_lock_down, death_rate_peack_of_lock_down,
death_rate_ease_of_lock_down, death_rate_from_vaccination into lockdown_series
from #temp_befor b
join #temp_start s 
on  b.continent = s.continent
join #temp_strict st 
on  b.continent = st.continent
join #temp_lose l
on  b.continent = l.continent
join #temp_vacc v
on  b.continent = v.continent
  
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
  
--Lets work on the case record across the seasons
-- Two clusters North and South hemisphere
WITH Season_Start AS (
    SELECT 
        continent, 
        YEAR(date) AS year, 
        CASE 
            -- 🌍 Northern Hemisphere (NA, EU, AS)
            WHEN continent IN ('North America', 'Europe', 'Asia') THEN 
                CASE 
                    WHEN MONTH(date) = 12 THEN 'Winter'
                    WHEN MONTH(date) = 3 THEN 'Spring'
                    WHEN MONTH(date) = 6 THEN 'Summer'
                    WHEN MONTH(date) = 9 THEN 'Autumn'
                END
            -- 🌍 Southern Hemisphere (SA, AF, OC)
            WHEN continent IN ('South America', 'Africa', 'Oceania') THEN 
                CASE 
                    WHEN MONTH(date) = 6 THEN 'Winter'
                    WHEN MONTH(date) = 9 THEN 'Spring'
                    WHEN MONTH(date) = 12 THEN 'Summer'
                    WHEN MONTH(date) = 3 THEN 'Autumn'
                END
        END AS season,
        MAX(total_cases) AS start_cases
    FROM CovidData
    WHERE 
        (continent IN ('North America', 'Europe', 'Asia') AND MONTH(date) IN (12, 3, 6, 9) AND DAY(date) = 1)
        OR
        (continent IN ('South America', 'Africa', 'Oceania') AND MONTH(date) IN (6, 9, 12, 3) AND DAY(date) = 1)
    GROUP BY continent, YEAR(date), 
        CASE 
            WHEN continent IN ('North America', 'Europe', 'Asia') THEN 
                CASE 
                    WHEN MONTH(date) = 12 THEN 'Winter'
                    WHEN MONTH(date) = 3 THEN 'Spring'
                    WHEN MONTH(date) = 6 THEN 'Summer'
                    WHEN MONTH(date) = 9 THEN 'Autumn'
                END
            WHEN continent IN ('South America', 'Africa', 'Oceania') THEN 
                CASE 
                    WHEN MONTH(date) = 6 THEN 'Winter'
                    WHEN MONTH(date) = 9 THEN 'Spring'
                    WHEN MONTH(date) = 12 THEN 'Summer'
                    WHEN MONTH(date) = 3 THEN 'Autumn'
                END
        END
)

SELECT 
    cd.continent, 
    YEAR(cd.date) AS year,
    ss.season,
    MAX(cd.total_cases) - ss.start_cases AS cases_during_season
FROM CovidData cd
JOIN Season_Start ss
    ON cd.continent = ss.continent
    AND YEAR(cd.date) = ss.year
WHERE 
    (
        (cd.continent IN ('North America', 'Europe', 'Asia') 
            AND ((ss.season = 'Winter' AND MONTH(cd.date) = 2 AND DAY(cd.date) = 28)  
                 OR (ss.season = 'Spring' AND MONTH(cd.date) = 5 AND DAY(cd.date) = 31)  
                 OR (ss.season = 'Summer' AND MONTH(cd.date) = 8 AND DAY(cd.date) = 31)  
                 OR (ss.season = 'Autumn' AND MONTH(cd.date) = 11 AND DAY(cd.date) = 30)))
        OR
        (cd.continent IN ('South America', 'Africa', 'Oceania') 
            AND ((ss.season = 'Winter' AND MONTH(cd.date) = 8 AND DAY(cd.date) = 31)  
                 OR (ss.season = 'Spring' AND MONTH(cd.date) = 11 AND DAY(cd.date) = 30)  
                 OR (ss.season = 'Summer' AND MONTH(cd.date) = 2 AND DAY(cd.date) = 28)  
                 OR (ss.season = 'Autumn' AND MONTH(cd.date) = 5 AND DAY(cd.date) = 31)))
    )
GROUP BY cd.continent, YEAR(cd.date), ss.season, ss.start_cases
ORDER BY cd.continent, YEAR(cd.date), ss.season;

