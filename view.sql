
create view angajat_bogat as  
select a.Nume, a.Prenume from angajat a where a.salar > 3000  and a.oras = 'Vaslui'; 



create view nr_inchirieri as
select  a.marca masina, count(c.nr_masina) nr_inchirieri from autoturisme a inner join contract c on 
a.Nr_Inmatriculare = c.nr_masina group by a.marca;   

create view perioada_inchiriere as
select a.marca, c.perioada from autoturisme a inner join contract c on a.Nr_Inmatriculare = c.nr_masina
and c.perioada > 28;

