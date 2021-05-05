--------MODULE 3----------

/*Anonymous Block
DECLARE --qui inserisco le variabili che intendo usare 

BEGIN -- QUi inserisco la logica

EXCEPTION --Qui gestisco le eccezioni

END;--Chiusura del blocco
*/

DECLARE
BEGIN 
NULL
END;



--Normalmente non ho output da plsql engine quindi usiamo
SET SERVEROUTPUT ON;
begin
  dbms_output.put_line('Hello World!');
end;

--Nested Blocks

begin
  dbms_output.put_line('Hello World!');
  begin
    dbms_output.put_line('Hello Nested!');
  end;
end;

------MODULE 4 PLSQL Variables
/*Ci sono 4 tipi di variabili 
1) scalar
2) reference
3) compsite (ossia le collections)
4) large objects
**/

--Naming conventions

--variables v_variable_name
--cursor cur_cursor_name
--exception e_exception_name
--procedure p_procedure_name
--bind variable b_bind_name

DECLARE
  --v_text VARCHAR2(50) NOT NULL DEFAULT 'HEllo';
  v_text VARCHAR2(50) NOT NULL := 'Welcome';
  v_number NUMBER NOT NULL := 50;
  v_double NUMBER(4,2) NOT NULL := 50.47; --NUmber(total cifre, precision)
  v_integer PLS_INTEGER NOT NULL := 47;
  v_float BINARY_FLOAT NOT NULL := 50.47f;
  v_double BINARY_DOUBLE NOT NULL := 50.47d;

  v_date DATE NOT NULL := SYSDATE;

  v_date2 DATE NOT NULL := '22-NOV-19';
  v_timestamp TIMESTAMP := SYSTIMESTAMP;
  
  v_bool BOOLEAN := TRUE; --Questo non è printable
  
begin
  v_text := 'Hello PLSQL';
  dbms_output.put_line(v_text);
  dbms_output.put_line(v_number);
  dbms_output.put_line(v_double);
  dbms_output.put_line(v_integer);
  dbms_output.put_line(v_date);
end;

--Using %TYPE attribute
/*****Serve ad assegnare il tipo di una colonna di una tabella al tipo di una variabile in questo modo il codice è anche resistente ai cambiamenti del db.
In questo modo i tipi non sono hardcoded ma sono puntatori ai tipi delle colonne della tabella in esame.****/

DECLARE
v_type employees.job_id%type;
v_type2 v_type%type; -- funziona anche per le variabili ovviamente
begin
  v_type := 'IT_PROG';
  dbms_output.put_line(v_type);
end;

/*******Variables Scoping********/
DECLARE 
v_outer varchar(50) := 'Outer';
begin

  DECLARE
    v_inner varchar(50) := 'Inner variable';
  begin
    dbms_output.put_line('Inside -> ' || v_outer); --Ok
    dbms_output.put_line('Inside_inner -> ' || v_inner); --Ok
  end;
  dbms_output.put_line(v_outer);
 -- dbms_output.put_line('Ouside inner -> ' || v_inner) Errore perche lo scope di una variabile è dentro un block quindi inner non è accessibile al di fuori del suo scope interno
end;

--valgono anche le regole di shadowing delle variabili cioè la variabile piu interna è quella in scope con lo stesso nome di una nello scope piu esterno


/************Bind variables***************/
--lo scope delle b-vars è tutto lo script e vengono dichiarate al di fuori della declare kwrd

variable var_text VARCHAR2(30);
begin
  :var_text := 'Hello Bind VAr!';
end;

--possono essere utili per usare on the fly le variabili in una query

variable var_sql number;
begin
  var_sql := 100;
end;

select *
  
  from employees e
 where e.employee_id = :var_sql;