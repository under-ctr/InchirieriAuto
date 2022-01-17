DELIMITER //
create trigger inserare_in_contract_masina 
before insert on contract 
for each row
begin
set @pret = 0; 
set @nr = new.nr_masina; 
set @nr_duba = new.nr_duba;
set @nr_speciala = new.nr_speciala;

if length(@nr) >= 7  then
		select Pret into @pret from autoturisme  where autoturisme.Nr_Inmatriculare = @nr;
		call calculeaza_reducere(new.perioada, @valoare);
		set new.pret_final = (@pret - @valoare) * new.perioada; 
elseif length(@nr_duba) >= 7 then
		select Pret into @pret from autoutilitare  where autoutilitare.Nr_Inmatriculare = @nr_duba;
		call calculeaza_reducere(new.perioada, @valoare);
		set new.pret_final = (@pret - @valoare) * new.perioada; 
elseif  length(@nr_speciala) >= 7  then
		select Pret into @pret from evenimente_speciale  where evenimente_speciale.Nr_Inmatriculare = @nr_speciala;
		call calculeaza_reducere(new.perioada, @valoare);
		set new.pret_final = (@pret - @valoare) * new.perioada;
end if;
end //
DELIMITER ;
 -- de implementat pentru autoutilitare
drop trigger inserare_in_contract_masina    ;


 
 DELIMITER //
create trigger inserare_istoric
before insert on contract 
for each row
begin

set @dataa = CURDATE();
set @datafinal = DATE_ADD(@dataa, INTERVAL new.perioada day);

insert into proiect.istoric_inchirieri(CNP, data_inchiriere,numar_zile, data_retur) values (new.cnp_client, @dataa, new.perioada, @datafinal);

end // 
DELIMITER ; 

DELIMITER //
create trigger bani_castigati 
before insert on contract 
for each row 
begin 
	set @nr = new.nr_masina;
    select suma_produs into @a from autoturisme  where Nr_inmatriculare = @nr ;
    set @b = new.pret_final;
    set @c = @a + @b;
	update autoturisme set suma_produs = @c 
    where Nr_inmatriculare = @nr; 
end // 
DELIMITER ;
drop trigger bani_castigati;
set @a = null;
