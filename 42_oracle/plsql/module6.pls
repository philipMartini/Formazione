/***USING SQL WITH PLSQL******/
DECLARE 
  v_name varchar2(50);
  v_salary employees.salary%type;
begin
  select e.last_name, e.salary
  into v_name, v_salary
  from employees e
  --è fondamentale che la where restituisca UNA SOLA RIGA
  where e.employee_id = 100;

  dbms_output.put_line('The salary of ' || v_name || ' Is ' || v_salary);
end;

/***DML OPerations in PLSQL*/

--Le operazioni nel loop vengono considerate UNA SOLA TRANSAZIONE 
begin
  for i in 207..216 loop
    insert into employees  (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    values (i, 'employee_id#'||i, 'temp_emp', 'abc@abc.com', sysdate,'IT_PROG', 1000);
  end loop;
end;

DECLARE
  v_salary_increase employees.salary%type := 400;
begin
  for i in 207..216 loop
    update employees e
       set e.salary= e.salary  + v_salary_increase;
     where e.employee_id = i;
  end loop;
end;



begin
  for i in 207..216 loop
    delete from employees e
     where e.employee_id = i;
  end loop;
end;

/**Using SEQUENCES IN PLSQL*/

CREATE sequence employee_id_sequence
start with 207
increment by 1;

--ovviamente la sequence non viene incrementata ad ogni chiamata
--ma viene incrementata per ogni statement
begin
  for i in 1..10 loop
    dbms_output.put_line('Counter Val Is ' || i)
    insert into employees  (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    values (employee_id_sequence.nextval, 'employee_id#'|| employee_id_sequence.nextval, 'temp_emp', 'abc@abc.com'||employee_id_sequence.nextval, sysdate,'IT_PROG', 1000);
  end loop;
end;

