--Composite Data Types

--record type
DECLARE
  r_emp empoyees%rowtype;
begin
  select *
    into r_emp
    from employees
   where employee_id = 101; -- deve restituire una sola row
   r_emp.salary := 20000;

   dbms_output.put_line(r_emp.first_name || ' ' || r_emp.last_name || e.salary);
end;

--custom record type

DECLARE
  type t_emp is record (first_name varchar2(50), last_name employees.last_name%type, salary employees.salary%type)

  r_emp t_emp;


begin
  select e.first_name, e.last_name, e.salary
    into r_emp
    from employees e
   where employee_id = 101; -- deve restituire una sola row
   r_emp.salary := 20000;

   dbms_output.put_line(r_emp.first_name || ' ' || r_emp.last_name || e.salary);
end;

--DML with records

CREATE TABLE retired_employees AS
SELECT *
FROM employees 
WHERE 1 = 2;

DECLARE 
  r_emp employees%rowtype
begin
  select *
    into r_emp
    from employees
   where employee_id = 104;
   --Questo puo essere utile quando è necessario fare operazioni sui campi PRIMA di inserire la row
   r_emp.salary := 0;
   r_emp.commission_pct := 0;
   insert into retired_employees values e_emp;
   --Con una update
   update retired_employees set row = r_emp where employee_id = 104;
end;

--COLLECTIONS

--VArrays collezione a dimensione NON modificabile
--lo starting index è 1
-- sono null di default

--varray.count() => il numero di elementi attualmente contenuti
-- varray.limit() => la dimensione dell'array

DECLARE
  type e_list is varray(5) of varchar2(50);
  c_employees_names e_list = e_list(); -- è necessario inizalizzare con il costruttore

begin
  --un'altra inizializzazione
  -- c_employees_names := e_list(....names.....)
  
  for i in 100..105 loop
    c_employees_names.extend; --Alloca un nuovo elemento
    select e.first_name
    into c_employees_names(indx)
    from employees e
   where e.employee_id = i;
   indx := indx + 1;
    
  end loop;
  

   for i in 1..c_employees_names.count() loop
     dbms_output.put_line(c_employees_names(i));
     end loop;
       
end;




--Nested Tables 
--Dimensione variabile 
-- Si possono cancellare valori
DECLARE
  type e_list is table of varchar2(50);
  emps e_list;

begin
  emps := e_list('Alex','Foo', 'Bar');
  for i in 1..emps.count() loop
    dbms_output.put_line(emps(i));
  end loop;
  emps.extend; --alloca un nuovo elemento
  emps(4) := 'Bob';
  dbms_output.put_line(emps(4));
end;


DECLARE
  type e_list is table of employees.first_name%type;
  emps e_list := e_list();
  indx number := 1;

begin
  for i in 100..110 loop
    emps.extend;
    select e.first_name
      into emps(indx)
      from employees
     where e.employee_id = 1;
     dbms_output.put_line('Inserted '|| emps(indx));
     indx := indx + 1;
    
  end loop;
  emps.delete(3); --cancella il terzo elemento
  for i in 1..emps.count() loop
    if emps.exists(i) then --Ma ora devo controllare che l'elemento esista
      dbms_output.put_line(emps(i));
    end if;
  end loop; 

end;

--ASSOCIATVIVE ARRAYS (MOST USED)
--In questo caso le chiavi possono essere Varchar, Number ma DEVONO ESSERE UNICHE
--Simile ad una mappa di fatto
--Non devono essere inizializzati

DECLARE
  type e_list is table of employees.first_name%type index by pls_integer;
  emps e_list;
  indx pls_integer;

begin
  for x in 100..110 loop
    select e.first_name
      into emps(x)
      from employees e
     where e.employee_id = x;
  end loop;

  indx := emps.first();
  while indx is not null loop
    dbms_output.put_line(emps(indx));
    indx := emps.next(indx);
  end loop;

end;


DECLARE
  type e_list is table of employees.first_name%type index by employees.email%type;
  emps e_list;
  email employees.email%type;
  v_email employees.email%type;
  v_first_name employees.first_name%type;

begin
  for x in 100..110 loop
    select e.first_name, e.email
      into v_first_name, v_email
      from employees e
     where e.employee_id = x;

    emps(v_email) := v_first_name;

  end loop;

  email := emps.first();
  while email is not null loop
    dbms_output.put_line(emps(email) || ' Indexed By ' || email);
    email := emps.next(email);
  end loop;

end;


--Using collections and records


DECLARE
  type e_list is table of employees%rowtype index by pls_integer;
  emps e_list;
  indx pls_integer;


begin
  for x in 100..110 loop
    select *
      into emps(x)
      from employees e
     where e.employee_id = x;


  end loop;
  emps.delete(100, 104); --cancellare in un range

  indx := emps.first();
  while indx is not null loop
    dbms_output.put_line(emps(indx).first_name || ' Indexed By ' || indx);
    indx := emps.next(indx);
  end loop;

end;


Create table employees_salary_history as 
select *
from employees
where 1 = 2;

alter table employees_salary_history add insert_date date;

DECLARE
  type e_list is table of employees_salary_history%rowtype index by pls_integer;
  emps e_list;
  indx pls_integer;

begin
  for x in 100..110 loop
    select e.*, '01-JUN-20'
    into emps(x)
    from employees e
   where e.employee_id = x;
    
  end loop;

  indx := emps.first();
  while indx is not null loop
    emps(indx).salary = emps(indx).salary + 2000;
    insert into employees_salary_history values emps(indx);
    dbms_output.put_line('Inserted ' || emps(indx).first_name);
    indx := emps.next(indx);
  end loop;
  


end;


--Inserting collection in a table

--crea nello schema l'object type (il record type non puo essere creato a livello di schema)
create or replace type t_phone_number as object (p_type varchar2(10), p_number varchar2(50));

--crea a livello di schema il tipo collezione
create or replace type v_phone_numbers as varray(3) of t_phone_number;


--crea la tabella nuova
create table emps_with_phone (employee_id number,
                              first_name varchar2(50),
                              last_name varchar2(50),
                              phone_number  v_phone_numbers);

insert into emps_with_phone values(10, 'Alex', 'Foo',
            v_phone_numbers(
              t_phone_number('Home', '111-1111'),
              t_phone_number('Office','22222-2222'),
              t_phone_number('Mobile', '333--3333')));



insert into emps_with_phone values(11, 'Al', 'Bar',
            v_phone_numbers(
              t_phone_number('Home', '111-1111'),
              t_phone_number('Office','22222-2222')));

--Table trasforma la collection in una table ed effettua il join con la tabella a cui appartiene
SELECT e.first_name, e.last_name, p.p_type, p.p_number
FROM emps_with_phone e, TABLE(e.phone_number) p;

--Usando Le nested Tables
--crea a livello di schema il tipo collezione
create or replace type n_phone_numbers as table of t_phone_number;

create table emps_with_phone2 (employee_id number,
                              first_name varchar2(50),
                              last_name varchar2(50),
                              phone_number  n_phone_numbers)
                              NESTED TABLE phone_number STORE AS 
                              phone_numbers_table;

--volendo aggiornare un valore alla nested table
update emps_with_phone2 set phone_number = n_phone_numbers( t_phone_number('Home', '111-1111'),
              t_phone_number('Office','22222-2222'),
              t_phone_number('Mobile', '333--3333'));

--e se volessi appendere un solo nuovo valore?
DECLARE
  p_num n_phone_numbers;

begin
  select e.phone_number
    into p_num
    from employees e
   where e.employee_id = 107;

  p_num.extend;
  p_num(p_num.count() + 1) := t_phone_number('New Mobile', '7777');
  update emps_with_phone2 set phone_number = p_num where e.employee_id = 107;
end;
