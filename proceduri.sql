
-- inserare in clienti
DELIMITER //
create procedure insereaza_client (CNP1 varchar(14), nume varchar(45), prenume varchar(45))
begin 
declare a varchar(14); 
set a = 0;
select CNP into a from client where CNP1 = client.CNP; 
    if length(a) <= 2 then 
			insert into client values(CNP1, nume, prenume);
	end if;
end //
DELIMITER ; 
drop procedure  insereaza_client
-- inserare in contract cand se inchireaza un autoturism 
DELIMITER //
create procedure insereaza_contract_masina(CNP int, nr varchar(7), per int  )
begin 

	insert into contract(cnp_client,nr_masina, perioada ) values( CNP , nr, per );
end //
DELIMITER ;

drop procedure insereaza_contract_masina
-- inserare in contract cand se inchireaza o autoutilitara 
DELIMITER //
create procedure insereaza_contract_duba(CNP varchar(14), nr varchar(7), per int )
begin 
	insert into contract(cnp_client, perioada, nr_duba ) values( CNP , per ,nr);
end //
DELIMITER ;
drop procedure insereaza_contract_duba;
-- inserare in contract cand se inchireaza o masina speciala
DELIMITER //
create procedure insereaza_contract_speciala(CNP varchar(14), nr varchar(7), per int )
begin 
	insert into contract(cnp_client, perioada, nr_speciala ) values( CNP , per,  nr);
end //
DELIMITER ;
drop procedure insereaza_contract_speciala;

-- calculeaza reducerea ce trebuie aplicata

DELIMITER //
create procedure calculeaza_reducere(in perioada int, out valoarea int )
begin
if perioada >= 1 and perioada <=7 then 
		set valoarea = 25;
	elseif perioada >=8  and perioada <=14 then
		set valoarea = 30;
	elseif perioada >=14 and perioada <= 21 then 
		set valoarea = 40;
	else 
		set valoarea = 50;
	end if;
end //
DELIMITER ;
drop procedure calculeaza_reducere;
call calculeaza_reducere(4, @valoare );
select @valoare;

drop procedure insereaza_contract_masina;
drop procedure insereaza_contract_duba;
drop procedure insereaza_contract_speciala;

-- insereaza un utilizator

DELIMITER // 
create procedure inserare_user (namee varchar(45), parolaa varchar(45))
begin 
declare a varchar(45); 
set a = 0;
select username into a from login where  namee = login.username; 
	if length(a) <= 2 then 
		insert into login(username, parola)	values(namee, parolaa); 
	end if;
end //

DELIMITER ; 
drop procedure inserare_user;
-- procedura vizualizare istoric 

-- afisaza istoric
DELIMITER //
create procedure vizualizare_istoric( cnp1 varchar(14) ) 
begin 
select data_inchiriere,numar_zile, data_retur from istoric_inchirieri i where cnp1 = i.cnp; 
end //
DELIMITER ;


  


