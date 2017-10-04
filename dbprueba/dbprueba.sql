Create table categoria(
  id serial PRIMARY KEY,
  nombre varchar (50) not null unique
  
);
Create table articulo(
  id serial PRIMARY KEY,
  nombre varchar (50) not null unique,
  precio decimal(10,2),
  categoria bigint 
  
);
INSERT INTO categoria(nombre) values ('categoría 1');

INSERT INTO categoria(nombre) values ('categoría 2');

INSERT INTO categoria(nombre) values ('categoría 3');

INSERT INTO articulo(nombre,precio,categoria) values ('articulo 1',1,1);
INSERT INTO articulo(nombre,precio,categoria) values ('articulo 2',2,2);
INSERT INTO articulo(nombre,precio,categoria) values ('articulo 3',3,1);
INSERT INTO articulo(nombre,precio,categoria) values ('articulo 4',4,4)
INSERT INTO articulo(nombre) values ('articulo 5');

SELECT * from articulo; 

select COUNT(a.id),a.categoria,c.nombre from articulo a 
left join  categoria c on c.id = a.categoria
group by a.categoria,c.nombre

1.Quiero todas las categorias sin articulos. 

select * from categoria c left join articulo a on a.categoria=c.id
where categoria is null

2.
