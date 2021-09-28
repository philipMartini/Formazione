


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

--Change salary of employee 115 to 8000 if the existing salary is less than 6000.
UPDATE employees e 
SET e.salary = 8000
WHERE e.employee_id = 115 AND e.salary < 6000;

--Insert a new employee into employees with all the required details.
INSERT INTO employees
(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE,JOB_ID, SALARY, DEPARTMENT_ID)
VALUES ((207, 'ANGELA', 'SNYDER','ANGELA','215 253 4737', SYSDATE, 'SA_MAN', 12000, 80);

--Delete department 20.
DELETE FROM departments d
WHERE d.department_id = 20;

--Change job ID of employee 110 to IT_PROG if the employee belongs to department 10 and the existing job ID does not start with IT.
UPDATE employees e
SET e.job_id = 'IT_PROG'
WHERE e.employee_id = 110 AND e.department_id = 10 AND NOT (e.job_id LIKE 'IT%';


--Insert a row into departments table with manager ID 120 and location ID in any location ID for city Tokyo.

INSERT INTO departments d (department_id, department_name, manager_id, location_id)
SELECT 47, 'NEW_DEPARMENT', 120, MAX(l.location_id)
FROM locations l 
WHERE l.city = 'Tokyo';

--Display department name and number of employees in the department.
SELECT d.department_name, COUNT(*) AS employees_number
FROM  employees e JOIN departments d 
ON e.department_id = d.department_id
GROUP BY d.department_id;


--Display job title, employee ID, number of days between ending date and starting date for all jobs in department 30 from job history.
SELECT j.job_title, jh.employee_id, (jh.end_date - jh.start_date) AS delta_days
FROM job_history jh JOIN jobs j ON (jh.job_id = j.job_id) 
JOIN  employees e ON (e.employee_id = jh.employee_id);

--Display department name, manager name, and city.
SELECT d.department_name, e.first_name, e.last_name, l.city 
FROM departments d JOIN locations l ON (d.location_id = l.location_id)
JOIN employees e ON (d.manager_id = e.employee_id);

--Display country name, city, and department name.
SELECT c.country_name, l.city, d.department_name
FROM countries c JOIN locations l ON (c.country_id = l.country_id)
JOIN departments d ON (l.location_id = d.location_id);


--Display job title, department name, employee last name, starting date for all jobs from 2000 to 2005.

SELECT j.job_title, d.department_name, e.last_name, jh.start_date
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
JOIN jobs j ON  (e.job_id = j.job_id)
JOIN job_history jh ON (e.employee_id = jh.employee_id)
WHERE TO_CAHR(jh.start_date, 'YYYY') BETWEEN 2000 AND 2005;

--Display job title and average salary of employees
SELECT AVG(e.salary) AS average_salary, j.job_title
FROM employees e JOIN jobs j ON (e.job_id = j.job_id)
GROUP BY j.job_title;

--Display job title, employee name, and the difference between maximum salary for the job and salary of the employee.
SELECT j.job_title, e.first_name, (j.max_salary - j.min_salary) AS delta_salary
FROM employees e JOIN jobs j ON (e.job_id = j.job_id)

--Display last name, job title of employees who have commission percentage and belongs to department 30.
SELECT e.last_name, j.job_title
FROM employees e JOIN j.jobs ON (e.job_id = j.job_id)
WHERE e.department_id = 30 AND e.commission_pct IS NOT NULL;

--Display details of jobs that were done by any employee who is currently drawing more than 15000 of salary.

SELECT jh.*, j.job_title
FROM employees e JOIN job_history jh ON (e.employee_id = jh.employee_id)
JOIN jobs j ON (jh.job_id = j.job_id)
WHERE e.salary > 15000;

--51. Display department name, manager name, and salary of the manager for all managers whose experience is more than 5 years.
SELECT m.first_name, m.last_name, m.salary, d.department_name
FROM employees m JOIN departments d ON (m.employee_id = d.manager_id)
WHERE (SYSDATE - m.hire_date ) / 365 > 5;

--52. Display employee name if the employee joined before his manager.

SELECT e.first_name
FROM employees e JOIN employees m ON (e.manager_id = m.employee_id)
WHERE e.hire_date < m.hire_date;

--53. Display employee name, job title for the jobs employee did in the past where the job was done less than six months.
SELECT e.first_name, j.job_title
FROM employees e JOIN job_history jh ON (e.employee_id = jh.employee_id)
JOIN jobs j ON (jh.job_id = j.job_id)
WHERE MONTHS_BETWEEN(jh.end_date, jh.end_date)  < 6;

--54. Display employee name and country in which he is working.
SELECT e.first_name, c.country_name
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
JOIN locations l ON (d.location_id = l.location_id) 
JOIN countries c ON (c.country_id = l.country_id); 

--55. Display department name, average salary and number of employees with commission within the department.
SELECT d.department_name, AVG(e.salary) AS avg_salary, COUNT(*) AS employees_in_department
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
WHERE e.commission_pct IS NOT NULL
GROUP BY d.department_name;

--56. Display the month in which more than 3 employees joined in any department located in Seattle.
SELECT TO_CHAR(e.hire_date, 'MON') AS hire_month, COUNT(*) as number_employees_joined
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
JOIN locations l ON (d.location_id = l.location_id)
WHERE LOWER(l.city) = 'seattle'
GROUP BY TO_CHAR(e.hire_date, 'MON')
HAVING COUNT(*) > 3;

--57. Display details of departments in which the maximum salary is more than 10000.

SELECT *
FROM departments d 
WHERE d.department_id IN (

    SELECT d.department_id
    FROM employees e
    GROUP BY e.department_id 
    HAVING MAX(e.salary) > 10000
    );

--58 Display details of departments managed by ‘Smith’

SELECT *
FROM departments d 
WHERE d.manager_id IN (
  SELECT m.employee_id
  FROM employees m
  WHERE LOWER(m.last_name) = 'smith'


);

--59. Display jobs into which employees joined in the current year.

SELECT *
FROM jobs j
WHERE j.job_id IN (

  SELECT e.job_id
  FROM employees e 
  WHERE TO_CHAR(e.hire_date,'YYYY') = TO_CHAR(SYSDATE, 'YYYY')


);


--60. Display employees who did not do any job in the past.
SELECT *
FROM employees e
WHERE e.employee_id NOT IN (
  SELECT jh.employee_id
  FROM job_history jh
);


--61. Display job title and average salary for employees who did a job in the past.
SELECT j.job_title, AVG(e.salary)
FROM employees e JOIN jobs j ON (e.job_id = j.job_id)
GROUP BY j.job_title
WHERE e.employee_id IN (

  SELECT jh.employee_id
  FROM job_history jh
);

--62. Display country name, city, and number of departments where department has more than 5 employees.

SELECT c.country_name, l.city, COUNT(*) AS number_of_departments
FROM departments d JOIN locations l ON (d.location_id = l.location_id)
JOIN countries c ON (c.country_id = l.country_id)
WHERE d.department_id IN  (
  SELECT d1.department_id
  FROM employees e JOIN departments d1 ON (e.department_id = d1.department_id)
  GROUP BY d1.department_id
  HAVING COUNT(*) > 5
  )
GROUP BY c.country_name, l.city;


--63. Display details of manager who manages more than 5 employees.
SELECT *
FROM employees m
WHERE m.employee_id IN (

  SELECT e.manager_id
  FROM employees e 
  GROUP BY e.manager_id
  HAVING COUNT(*) > 5


);

--64. Display employee name, job title, start date, and end date of past jobs of all employees with commission percentage null.

SELECT e.first_name, j.job_title, jh.start_date, jh.end_date
FROM employees e JOIN job_history jh ON (e.employee_id = jh.employee_id)
JOIN jobs j ON (jh.job_id = j.job_id)
WHERE e.commission_pct IS NULL;


--65 Display the departments into which no employee joined in last 14 years.

SELECT d.department_name
FROM departments d

MINUS 

SELECT d.department_name
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
WHERE  ((SYSDATE - e.hire_date) / 365) < 14;


--66. Display the details of departments in which the max salary is greater than 10000 for employees who did a job in the past.
SELECT *
FROM departments d 
WHERE d.department_id IN (
  SELECT d1.department_id
  FROM job_history jh JOIN jobs j ON (jh.job_id = j.job_id)
  WHERE j.max_salary > 10000;

);

--67. Display details of current job for employees who worked as IT Programmers in the past.

SELECT j.job_id, j.job_title
FROM jobs j JOIN employees e ON (j.job_id = e.job_id)
WHERE  e.employee_id IN (

  SELECT e1.employee_id
  FROM job_history jh
  WHERE jh.job_id = 'IT_PROG'

);

--68. Display the details of employees drawing the highest salary in the department.

SELECT *
FROM employees e 
WHERE e.salary, e.department_id IN (
  SELECT MAX(e1.salary), e1.department_id
  FROM employees e1
  GROUP BY e1.department_id
);

--Con le query nidificate
SELECT DEPARTMENT_ID,FIRST_NAME, SALARY 
FROM EMPLOYEES e 
WHERE SALARY =(
  SELECT MAX(SALARY) 
  FROM EMPLOYEES 
  WHERE DEPARTMENT_ID = OUTER.DEPARTMENT_ID
  );

--69. Display the city of employee whose employee ID is 105.
-- farlo con query nidificate
SELECT l.city
FROM locations l 
WHERE l.location_id = (
  SELECT d.location_id
  FROM departments d
  WHERE d.department_id = (
    SELECT e.department_id
    FROM employees e 
    WHERE e.employee_id = 105
  )

);

--70. Display third highest salary of all employees
SELECT  *
FROM (
  SELECT e.salary, ROW_NUMBER() OVER (ORDER BY e.salary DESC) rn
  FROM employees e
)
WHERE rn = 3;