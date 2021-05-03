


-------------------------------------------------------------------
--Display details of jobs where the minimum salary is greater than  10000.
---------------------------------------------------------------------------
SELECT * 
FROM jobs j
WHERE j.min_salary > 10000;


-------------------------------------------------------------------
--Display the first name and join date of the employees who joined between 2002 and 2005.
---------------------------------------------------------------------------

SELECT e.first_name, e.hire_date
FROM employees e
WHERE TO_CHAR(e.hire_date, 'YYYY') BETWEEN 2002 AND 2005;

--Display first name and join date of the employees who is either IT Programmer or Sales Man.

SELECT e.first_name, e.hire_date
FROM employees e 
WHERE e.job_id = 'IT_PROG' OR e.job_id = 'SA_MAN';

--Display employees who joined after 1st January 2008.
SELECT e.first_name, e.last_name
FROM employees e 
WHERE e.hire_date > '01-JAN-2008';

--Display details of employee with ID 150 or 160.
SELECT e.employee_id, e.first_name, e.last_name
FROM employees e 
WHERE e.employee_id = 150 OR e.employee_id = 160;

--Display first name, salary, commission pct, and hire date for employees with salary less than 10000.

SELECT e.employee_id, e.first_name, e.last_name, e.salary
FROM employees e 
WHERE e.salary < 10000;

--Display job Title, the difference between minimum and maximum salaries for jobs with max salary in the range 10000 to 20000.

SELECT j.job_title, (max_salary - min_salary) AS salary_delta
FROM jobs j 
WHERE j.max_salary BETWEEN 10000 AND 20000;

--Display first name, salary, and round the salary to thousands.

SELECT e.first_name, ROUND(e.salary, -3)
FROM employees e;

--Display details of jobs in the descending order of the title.
SELECT *
FROM jobs j 
ORDER BY j.job.title DESC;

--Display employees where the first name or last name starts with S.

SELECT e.last_name, e.first_name
FROM employees e 
WHERE UPPER(e.last_name) LIKE '%S' OR UPPER(e.first_name) LIKE '%S';

--Display employees who joined in the month of May.
SELECT *
FROM employees e 
WHERE UPPER(TO_CHAR(e.hire_date, 'MON')) = 'MAY';

--Display details of the employees where commission percentage is null and salary in the range 5000 to 10000 and department is 30.

SELECT *
FROM employees e 
WHERE e.commission_pct IS NULL AND e.salary BETWEEN 5000 AND 10000 AND e.department_id = 30;

--Display first name and last name after converting the first letter of each name to upper case and the rest to lower case.

SELECT INITCAP(e.first_name), INITCAP(e.last_name)
FROM employees e;

--Display the first word in job title.
SELECT SUBSTR(j.job_title, 1, INSTR(j.job_title, '')-1)
FROM jobs j;


--Display the length of first name for employees where last name contain character ‘b’ after 3rd position.
SELECT LENGTH(e.first_name)
FROM employees e 
WHERE  INSTR(e.last_name,'b') > 3;

--Display first name in upper case and email address in lower case for employees where the first name and email address are same irrespective of the case.


SELECT UPPER(e.first_name), LOWER(e.email)
FROM employees e 
WHERE UPPER(e.first_name) = UPPER(e.email);

--Display the number of days between system date and 1st January 2011.
SELECT sysdate - TO_DATE('01-JAN-2011') FROM DUAL;

--Display how many employees joined in each month of the year 2011.
SELECT COUNT(*), TO_CHAR(e.hire_date, 'MON') AS hire_month;
FROM employees e 
WHERE TO_CHAR(e.hire_date, 'YYYY') = 2003
GROUP BY TO_CHAR(e.hire_date, 'MON');

--Display manager ID and number of employees managed by the manager
SELECT COUNT(*) as number_of_employees_managed_by, e.manager_id
FROM employees e 
GROUP BY e.manager_id;

--Display employee ID and the date on which he ended his previous job.
SELECT jh.employee_id, MAX(jh.start_date)
FROM job_history jh 
GROUP BY jh.employee_id;

--Display number of employees joined after 15th of the month.
SELECT COUNT(*)
FROM employees e 
WHERE TOCAHR(e.hire_date, 'DD') = 15;

--Display the country ID and number of cities we have in the country.

SELECT COUNT(*) AS number_of_cities, l.country_id
FROM locations l 
GROUP BY l.country_id;

--Display average salary of employees in each department who have commission percentage.
SELECT AVG(e.salary), e.department_id
FROM employees e 
WHERE e.commission_pct IS NOT NULL
GROUP BY e.department_id;


--Display job ID, number of employees, sum of salary, and difference between highest salary and lowest salary of the employees of the job.

SELECT e.job_id, COUNT(*) AS employees_number, SUM(e.salary) AS salaries_sum, (MAX(e.salary) - MIN(e.salary)) as salary_delta
FROM employees e 
GROUP BY e.job_id;

--Display job ID for jobs with average salary more than 10000.
SELECT e.job_id, AVG(e.salary)
FROM employees e
GROUP BY e.job_id
HAVING AVG(e.salary) > 10000;

--Display years in which more than 10 employees joined.
SELECT TO_CHAR(e.hire_date, 'YYYY') AS joining_year, COUNT(*)
FROM employees e 
GROUP BY TO_CHAR(e.hire_date, 'YYYY')
HAVING COUNT(*) > 10;

--Display departments in which more than five employees have commission percentage.
SELECT e.department_id, COUNT(*)
FROM employees e 
WHERE e.commission_pct IS NOT NULL
GROUP BY e.department_id
HAVING COUNT(*) > 5;

--Display employee ID for employees who did more than one job in the past.
SELECT jh.employee_id, COUNT(*) as jobs_number
FROM job_history jh 
GROUP BY jh.employee_id
HAVING COUNT(*) > 1;

--Display job ID of jobs that were done by more than 3 employees for more than 100 days.

SELECT jh.job_id
FROM job_history jh
WHERE jh.end_date - jh.start_date > 100
GROUP BY e.employee_id
HAVING COUN(*) > 3;

--Display department ID, year, and Number of employees joined.
SELECT e.department_id, TO_CHAR(e.hire_date, 'YYYY') AS joining_year, COUNT(*)
FROM employees e 
GROUP BY e.department_id, TO_CHAR(e.hire_date, 'YYYY')
ORDER BY TO_CHAR(e.hire_date, 'YYYY');

--Display departments where any manager is managing more than 5 employees.
SELECT DISTINCT e.department_id, COUNT(*)
FROM employees e 
GROUP BY e.department_id, e.manager_id
HAVING COUNT(*) > 5;