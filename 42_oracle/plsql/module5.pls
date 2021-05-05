/**IF ELSE BLOCKS*/

DECLARE 
v_number NUMBER := 30;
begin
  if v_number < 10 then
    dbms_output.put_line('Smaller Than 10');
  elsif v_number < 20 then
     dbms_output.put_line('Smaller Than 20');
  else
      dbms_output.put_line('Greater or equal to 20');
  end if;
end;

/**Basic Loops*/

declare 
  v_counter NUMBER := 1;

begin
  loop
    dbms_output.put_line('My Counter is: ' || v_counter)
    v_counter = v_counter + 1;
    if v_counter >= 10 then
      exit;
    end if;
  end loop;
end;

/***While Loops*****/
DECLARE
 v_counter NUMBER := 0;

 BEGIN
    WHILE v_counter <= 10 LOOP
      dbms_output.put_line('COunt value is: ' || v_counter);
      v_counter := v_counter + 1;
      --volendo posso aggiungere un break
      --EXIT when v_counter > 3; 
    END LOOP;

 END;

 /***** FOR LOOPS ******/
BEGIN 

FOR i in REVERSE 1..3 LOOP
  dbms_output.put_line('Mu COunter is: ' || i);
  END LOOP;

END;



DECLARE
  v_inner NUMBER := 1;
BEGIN
  <<outer_loop>>
  for  v_outer in 1..10 loop
    dbms_output.put_line('My Outer value is: ' || v_outer);
    v_inner := 1;
    
    <<inner_loop>>
    while v_inner * v_outer < 15 loop
      v_inner := v_inner + 1;
      --continue when mod(v_inner * v_outer, 3) = 0;
      continue outer_loop when mod(v_inner * v_outer, 3) = 0; 
      dbms_output.put_line('My Inner Value Is: ' || v_inner);
    end inner_loop;
  end outer_loop;

END;



