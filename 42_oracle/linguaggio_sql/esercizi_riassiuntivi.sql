---------------------------------------------------------------------------
-- Write a query to identify all the employees who are managers. This will
-- require using a subquery in the WHERE clause to select all the employees
-- whose EMPLOYEE_ID appears as a MANAGER_ID
---------------------------------------------------------------------------

SELECT *
FROM employees e
WHERE e.employee_id IN (
    SELECT m.manager_id
    from employees m
);

--Usando EXITS

SELECT *
FROM employees e
WHERE EXISTS (
        SELECT NULL
        FROM employees m
        WHERE e.employee_id = m.manager_id

);



---------------------------------------------------------------------------
-- Write a query to identify the highest salary paid in each country. This will
-- require using a subquery in the FROM clause
---------------------------------------------------------------------------

SELECT c.country_name, MAX(e.salary)
FROM  employees e JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
JOIN countries c ON l.country_id = c.country_id
GROUP BY c.country_name;


---------------------------------------------------------------------------
-- Write a query that will identify all employees who work in departments
-- located in the United Kingdom.
---------------------------------------------------------------------------
SELECT e.employee_id, e.first_name
FROM employees e
WHERE e.department_id IN (

    SELECT d.department_id
    FROM departments d
    WHERE d.location_id IN (
      SELECT l.location_id
      FROM locations l
      WHERE l.country_id = (
          SELECT c.country_id
          FROM countries c
          WHERE c.country_name = 'United Kingdom'
      )

    )

  );

  ---------------------------------------------------------------------------
-- Write a query to identify all the employees who earn more than the average
-- and who work in any of the IT departments.   
---------------------------------------------------------------------------  

SELECT e.employee_id, e.first_name, e.last_name, e.department_id, e.salary
FROM employees e 
WHERE e.department_id IN (

        SELECT d.department_id
        FROM departments d
        WHERE d.department_name LIKE '%IT%'
      )
      AND e.salary > (
        SELECT AVG(e1.salary)
        FROM employees e1
      );

---------------------------------------------------------------------------
-- Write a query to determine who earns more than Mr. Tobias
---------------------------------------------------------------------------

SELECT e.employee_id, e.first_name, e.last_name, e.salary
FROM employees e
WHERE e.salary > (

    SELECT e1.salary
    FROM employees e1
    WHERE UPPER(e1.last_name) = 'TOBIAS'


);


---------------------------------------------------------------------------           
-- Employees have their current job (identified by JOB_ID) recorded in their EMPLOYEES row.
-- Jobs they have held previously (but not their current job) are recorded in JOB_HISTORY.
-- Which employees have never changed jobs? The listing should include the employeesÃ¢â‚¬â„¢
-- EMPLOYEE_ID and LAST_NAME.
---------------------------------------------------------------------------

SELECT e.employee_id, e.last_name
FROM employees e
WHERE e.employee_id NOT IN(

  SELECT jh.employee_id
  FROM job_history jh   
);

---------------------------------------------------------------------------
-- This query attempted to find all employees whose salary is higher than that
-- of a nominated employee:using the
-- ANY comparison operator
---------------------------------------------------------------------------

SELECT e.employee_id, e.first_name, e.last_name
FROM employees e  
WHERE e.salary > ALL (
  SELECT e1.salary
  FROM employees e1
  WHERE UPPER(e1.first_name) = 'JOHN'
);

--Volendo Usare ANY
SELECT e.employee_id, e.first_name, e.last_name
FROM employees e  
WHERE NOT(e.salary <= ANY (
  SELECT e1.salary
  FROM employees e1
  WHERE UPPER(e1.first_name) = 'JOHN'
));

---------------------------------------------------------------------------
-- Which employees were recruited into one job, then changed to a different job, but are now
-- back in a job they held before? Again, you will need to construct a query that compares
-- EMPLOYEES with JOB_HISTORY. The report should show the employeesÃ¢â‚¬â„¢ names and the job
-- titles. Job titles are stored in the table JOBS.
---------------------------------------------------------------------------

--Gli impiegati che hanno cambiato lavoro


SELECT jh.employee_id, jh.job_id
FROM employees e JOIN job_history jh ON e.employee_id = jh.employee_id
WHERE e.employee_id IN (
  SELECT jh.employee_id
  FROM job_history jh
  GROUP BY jh.employee_id
  HAVING COUNT(*) = 2;

)

INTERSECT

SELECT e.employee_id, e.job_id
FROM employees e ;


--------------------------------------------------------------------------- 
-- What jobs has any one employee held? This will be the JOB_ID for the employeeÃ¢â‚¬â„¢s current
-- job (in EMPLOYEES) and all previous jobs (in JOB_HISTORY). If the employee has held a
-- job more than once, there is no need to list it more than once. Use a replacement variable to
-- prompt for the EMPLOYEE_ID and display the job title(s). Employees 101 and 200 will be
-- suitable employees for testing.
---------------------------------------------------------------------------

SELECT e.employee_id, e.job_id
FROM employees e 
WHERE e.employee_id = 101

UNION

SELECT jh.employee_id, jh.job_id
FROM job_history jh
WHERE jh.employee_id = 101;