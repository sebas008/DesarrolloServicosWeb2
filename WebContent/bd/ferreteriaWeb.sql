drop database if exists ferreteriaWeb;

create database ferreteriaWeb;

use ferreteriaWeb;

CREATE TABLE tb_usuario
(
	cod_usu			char(4) primary key not null,
    nombre			varchar(35) not null,
    apellido		varchar(35) not null,
    email			varchar(55) not null,
    clave			varchar(30) not null,
    cod_dis			char(4) not null references tb_distrito(cod_dis),
    direccion		varchar(60) not null,
    telefono		char(9) not null ,
    DNI				char(8) not null,
    administrador   bool default false
);

CREATE TABLE tb_distrito
(
	cod_dis			char(4) primary key not null,
    nombre			varchar(30)not null
);

CREATE TABLE tb_producto
(
	cod_prod	char(4) primary key not null,
    cod_cate	char(4) references tb_categorias(cod_cate),
    descripcion	varchar(100) not null,
    marca 		varchar(20) not null,
    uni_med		varchar(30) not null,
    stock_act	int not null,
    stock_min	int not null,
    precio		decimal(10,2) not null
);


 /*Electricos*/
 /*Cables*/
 insert into tb_producto values('P001','C001', 'Cable para bateria de auto 3.7M', 'Best Light', 'unidad', 20, 5, 41.6);
 insert into tb_producto values('P002','C001', 'Cable coaxial 305M', 'Schubert', 'unidad', 20, 5, 187.8);
 insert into tb_producto values('P003','C001', 'Cable UTP CAT-5E 305M', 'Schubert', 'unidad', 20, 5, 233.3);
 /*Focos*/
 insert into tb_producto values('P004','C001', 'Foco ahorrador 2U', 'Top Light', 'unidad', 60, 10, 3.7);
 insert into tb_producto values('P005','C001', 'Foco ahorrador 4U', 'Top Light', 'unidad', 60, 10, 7);
 insert into tb_producto values('P006','C001', 'Foco ahorrador LED de 5W', 'Top Light', 'unidad', 60, 10, 8.5);
 insert into tb_producto values('P007','C001', 'Foco LED multicolor 2W', 'Top Light', 'unidad', 60, 10, 11.9);
 insert into tb_producto values('P008','C001', 'Foco de color', 'Top Light', 'unidad', 60, 10, 18.7);
 /*Toma-Corrientes*/
 insert into tb_producto values('P009','C001', 'Cargador USB + Toma Universal Blanco', 'Bticino', 'unidad', 60, 10, 92.9);
 insert into tb_producto values('P010','C001', 'Pack x 20 Interruptor Simple Dormitorio', 'Ticino', 'unidad', 60, 10, 109.9);
 insert into tb_producto values('P011','C001', 'Tomacorriente doble al champagne', 'Bticino', 'unidad', 60, 10, 49.9);
 /*Extenciones*/
 insert into tb_producto values('P012','C001', 'Extenciones 10M', 'Top Light', 'unidad', 60, 10, 2.9);
 insert into tb_producto values('P013','C001', 'Supresor de pico', 'Top Light', 'unidad', 60, 10, 41.1);
 /*Enchufes*/
 insert into tb_producto values('P014','C001', 'Enchufe E/plana estandar', 'Top Light', 'unidad', 60, 10, 0.7);
 insert into tb_producto values('P015','C001', 'Enchufe plano reversible ticino', 'Bticino', 'unidad', 60, 10, 11.9);
 insert into tb_producto values('P016','C001', 'Enchufe universal plan 6 A 220 v', 'Epem', 'unidad', 60, 10, 2.9);
 insert into tb_producto values('P017','C001', 'Enchufe giratorio', 'Bticino', 'unidad', 60, 10, 19.9);
 insert into tb_producto values('P018','C001', 'Enchufe 2P+T 15A 125V L/T PVC Amarillo', 'Leviton', 'unidad', 60, 10, 17.9	);
 insert into tb_producto values('P019','C001', 'Enchufe 2 Patas Polarizada Blanco', 'Leviton', 'unidad', 60, 10, 15.9);
 
 /*Herramientas*/
 /*Taladros*/
 insert into tb_producto values('P020','C002', 'Taladro Atornillador/Percutor DCD985L2 20', 'Dewalt', 'unidad', 30, 4, 1299.9);
 insert into tb_producto values('P021','C002', 'Taladro Percutor GSB 13RE 650 W', 'Bosch', 'unidad', 30, 4, 199.9);
 insert into tb_producto values('P022','C002', 'Atornillador de Juguete Mini', 'Bosch', 'unidad', 30, 4, 12.3);
 /*Alicates*/
 insert into tb_producto values('P023','C002', 'Alicate mini set 3pz', 'Linea 196', 'unidad', 60, 10, 12.3);
 insert into tb_producto values('P024','C002', 'Alicate pico de loro de 10" ', 'Schubert', 'unidad', 60, 10, 20.8);
 insert into tb_producto values('P025','C002', 'Alicate mecanico 8°', 'Schubert', 'unidad', 60, 10, 10.3);
 /*Martillos*/
 insert into tb_producto values('P026','C002', 'Comba de acero mango fibra de vidrio de 10LB', 'Schuberts', 'unidad', 60, 10, 12.3);
 insert into tb_producto values('P027','C002', 'Martillo de uña 0.25kg/25mm', 'Schuberts', 'unidad', 60, 10, 14.6);
 insert into tb_producto values('P028','C002', 'Comba de acero con fibra de vidrio 16LB', 'Schuberts', 'unidad', 60, 10, 14.6);
 /*Brochas*/
 insert into tb_producto values('P029','C002', 'Brocha multiuso 1°', 'Tumi', 'unidad', 60, 10, 6.5);
 insert into tb_producto values('P030','C002', 'Brocha multiuso 1° 1/2', 'Tumi', 'unidad', 60, 10, 7.8);
 insert into tb_producto values('P031','C002', 'Brocha multiuso 2°', 'Tumi', 'unidad', 60, 10, 13.5);
 insert into tb_producto values('P032','C002', 'Brocha multiuso 3°', 'Tumi', 'unidad', 60, 10, 14.0);
 insert into tb_producto values('P033','C002', 'Brocha multiuso 4°', 'Tumi', 'unidad', 60, 10, 24.0);
 insert into tb_producto values('P034','C002', 'Brocha multiuso 5°', 'Tumi', 'unidad', 60, 10, 42.9);
 /*Linternas*/
 insert into tb_producto values('P035','C002', 'Linterna de Cuerpo Goma y 2 Pilas AA', 'Energizer', 'unidad', 60, 10, 49.9);
 insert into tb_producto values('P036','C002', 'Linterna Recargable MS-6048', 'Macrotel', 'unidad', 60, 10, 10.4);
 insert into tb_producto values('P037','C002', 'Spotlight Super bright LED Recargable 10W', 'Opalux', 'unidad', 60, 10, 189.9);
 /*Limpieza*/
 /*Detergentes y limpiadores*/
 insert into tb_producto values('P038','C003', 'Lejía desinfectante 4 L', 'Clorox', 'unidad', 60, 10, 12.9);
 insert into tb_producto values('P039','C003', 'Lejía desinfectante 3 L', 'Karson', 'unidad', 60, 10, 11.9);
 insert into tb_producto values('P040','C003', 'Dukto profesional 1 L', 'Tekno', 'unidad', 60, 10, 11.5);
 /*Utencilios de limpieza*/
 insert into tb_producto values('P041','C003', 'Balde con escurridor + Trapeador', 'Rey', 'unidad', 60, 10, 15.9);
 insert into tb_producto values('P042','C003', 'Recogedor rectráctil negro', 'Rubbermaid', 'unidad', 60, 10, 49.9);
 insert into tb_producto values('P043','C003', 'Limpia vidrios extensible 110 - 198 cm', 'Kleine', 'unidad', 60, 10, 44.9);
 /*Insectisidas y repelentes*/
 insert into tb_producto values('P044','C003', 'Baygon 6 doble espirales', 'Baygon', 'unidad', 60, 10, 3.0);
 insert into tb_producto values('P045','C003', 'Mata moscas 360 ml', 'Sapolio', 'unidad', 60, 10, 8.5);
 insert into tb_producto values('P046','C003', 'Raid Multi 313 gr', 'Raid', 'unidad', 60, 10, 12.5);
 /*Cocina*/
 insert into tb_producto values('P047','C003', 'Mr. Músculo cocina 500 ml', 'Johnson', 'unidad', 60, 10, 5.3);
 insert into tb_producto values('P048','C003', 'Sacagrasa limon 5L', 'Sapolio', 'unidad', 60, 10, 22.9);
 insert into tb_producto values('P049','C003', 'Limpiador multiusos con gatillo x 500ml', 'Easy Off', 'unidad', 60, 10, 14.9);
 /*Aerosoles y ambientadores*/
 insert into tb_producto values('P050','C003', 'Pack 2 repuestos Glade Manzana & Canela', 'SC Jhonson', 'unidad', 60, 10, 34.2);
 insert into tb_producto values('P051','C003', 'Dispensador perfumador automático', 'Sapolio', 'unidad', 60, 10, 34.0);
 /*Pinturas*/
 /*Latex*/
 insert into tb_producto values('P053','C004', 'Látex Pato Beige Mate 1gl', 'CPP', 'unidad', 60, 10, 28.0);
 insert into tb_producto values('P054','C004', 'Látex Supermate Marfil Mate 1gl', 'Vencedor', 'unidad', 60, 10, 12.9);
 insert into tb_producto values('P055','C004', 'Látex Superior Tint 4L', 'Ceresita', 'unidad', 60, 10, 31.9);
 /*Esmalte*/
 insert into tb_producto values('P056','C004', 'Esmalte al Agua Marrón Brillante 946ml', 'Rust-Oleum', 'unidad', 60, 10, 31.9);
 insert into tb_producto values('P057','C004', 'Esmalte sintético Estándar negro 1/4 gl', 'Kolor', 'unidad', 60, 10, 12.9);
 insert into tb_producto values('P058','C004', 'Esmalte para Metales Base Pastel 1GL', 'Kolor', 'unidad', 60, 10, 23.9);
 /*Barniz*/
 insert into tb_producto values('P059','C004', 'Barniz DD Crystal Transparente 1 gl', 'Tekno', 'unidad', 60, 10, 119.9);
 insert into tb_producto values('P060','C004', 'Barniz Doble Acción Transparente 1 gl', 'Tekno', 'unidad', 60, 10, 87.9);
 insert into tb_producto values('P061','C004', 'Varathane barniz marino brillante 1gl', 'Varathane', 'unidad', 60, 10, 194.9);
 /*Temples*/
 insert into tb_producto values('P062','C004', 'Temple blanco 25 kg', 'Majestad', 'unidad', 60, 10, 20.0);
 insert into tb_producto values('P063','C004', 'Temple Fino Sinolit blanco 25Kg', 'CPP', 'unidad', 60, 10, 47.9);
 insert into tb_producto values('P064','C004', 'Temple fino 25 kg', 'Sinolac', 'unidad', 60, 10, 39.9);
 /*Lijas*/
 insert into tb_producto values('P065','C004', 'Lija agua # 150', 'Asa', 'unidad', 60, 10, 1.9);
 insert into tb_producto values('P066','C004', 'Lija Fierro # 180', 'Asa', 'unidad', 60, 10, 2.3);
 insert into tb_producto values('P067','C004', 'Lija Madera # 40', 'Asa', 'unidad', 60, 10, 2.3);
 /*Gafiteria*/
 /*Griferia*/
 insert into tb_producto values('P068','C005', 'Mezcladora de lavatorio Line 8"', 'Vainsa', 'unidad', 60, 10, 590.0);
 insert into tb_producto values('P069','C005', 'Llave esférica para botadero 1/2 cromado', 'Schubert', 'unidad', 60, 10, 15.0);
 insert into tb_producto values('P070','C005', 'Valvula esferica 1', 'Schubert', 'unidad', 60, 10, 14.0);
 /*Tuberia*/
 insert into tb_producto values('P071','C005', 'Tubo PVC-U 1 1/2" x 5 m C/R', 'Pavco', 'unidad', 60, 10, 74.9);
 insert into tb_producto values('P072','C005', 'Tubo SAL para Desagüe 2"', 'Matusita Tigre', 'unidad', 60, 10, 8.7);
 insert into tb_producto values('P073','C005', 'Tubo CPVC 1/2"', 'Pavco', 'unidad', 60, 10, 16.5);
 /*Pegamentos*/
 insert into tb_producto values('P074','C005', 'Cemento PVC 32 oz Naranja', 'Oatey', 'unidad', 60, 10, 45.0);
 insert into tb_producto values('P075','C005', 'Cemento PVC / CPVC Mediano 8 oz Negro', 'Oatey', 'unidad', 60, 10, 17.9);
 insert into tb_producto values('P076','C005', 'Cemento para PVC 327 ml', 'Oatey', 'unidad', 60, 10, 16.9);
 /*Lavaderos*/
 insert into tb_producto values('P077','C005', 'Lavadero Watrfall 2 pozas con escurridor 116x50cm gris', 'Record', 'unidad', 60, 10, 3499.9);
 insert into tb_producto values('P078','C005', 'Lavadero City 2 pozas con escurridor 115x50cm crema', 'Record', 'unidad', 60, 10, 2549.9);
 insert into tb_producto values('P079','C005', 'Lavadero Aspen 1 Poza 54 x 44 cm', 'Record', 'unidad', 60, 10, 729.9);
 /*Conexiones*/
 insert into tb_producto values('P080','C005', 'Unión 1" SP', 'Tuboplast', 'unidad', 60, 10, 1.9);
 insert into tb_producto values('P081','C005', 'Unión universal 1 1/2"', 'Humboldt', 'unidad', 60, 10, 13.9);
 insert into tb_producto values('P082','C005', 'Unión Hembra 1/4 x 1/8', 'Eckogrif', 'unidad', 60, 10, 6.9);
 

 
CREATE TABLE tb_categoria
(
	cod_cate	char(4) primary key not null,
    descripcion varchar(30) not null
);

 insert into tb_categoria values('C001', 'Electricos');
 insert into tb_categoria values('C002', 'Herramientas');
 insert into tb_categoria values('C003', 'Limpieza');
 insert into tb_categoria values('C004', 'Pinturas');
 insert into tb_categoria values('C005', 'Gafiteria');
 

CREATE TABLE tb_ventas
(
	num_venta 	char(4) primary key not null,
	fec_Venta 	date not null,
	cod_usu	char(4) not null references tb_usuario(cod_usu)
);

CREATE TABLE tb_detalle_venta
(
	num_venta 	char(4) not null references tb_ventas(num_venta),
	cod_prod	char(4) not null references tb_producto(cod_prod),
	cant_prod 	int not null,
    subtotal	decimal(10,2) not null
);


select * from tb_usuario;
select * from tb_distrito;

select * from tb_ventas;
select * from tb_detalle_venta;
select * from tb_producto;


select max(num_venta), fec_Venta, cod_usu from tb_ventas;

insert into tb_distrito values('D001', 'Miraflores');
insert into tb_distrito values('D002', 'Surquillo');
insert into tb_distrito values('D003', 'Bellavista');
insert into tb_distrito values('D004', 'Ventanilla');
insert into tb_distrito values('D005', 'Lima');
insert into tb_distrito values('D006', 'Ancón');
insert into tb_distrito values('D007', 'Ate');
insert into tb_distrito values('D008', 'Barranco');
insert into tb_distrito values('D009', 'Breña');
insert into tb_distrito values('D010', 'Santa Anita');
insert into tb_distrito values('D011', 'Chorrillos');
insert into tb_distrito values('D012', 'Comas');
insert into tb_distrito values('D013', 'El Agustino');
insert into tb_distrito values('D014', 'La Victoria');
insert into tb_distrito values('D015', 'Lince');
insert into tb_distrito values('D016', 'S.J.L');

insert into tb_usuario values('C001', 'Jose', 'Damaso', 'profe@gmail.com', 'poo', 'D001', 'Av. POO', '927364332', '12645345', false);

insert into tb_ventas values('V001', '2018/10/30', 'C001');
insert into tb_detalle_venta values('V001', 'P001', 2, 83.20);
insert into tb_detalle_venta values('V001', 'P003', 1, 233.30);
insert into tb_detalle_venta values('V001', 'P004', 3, 11.10);

insert into tb_ventas values('V002', '2018/11/02', 'C001');
insert into tb_detalle_venta values('V002', 'P016', 2, 5.80);
insert into tb_detalle_venta values('V002', 'P018', 4, 71.60);
insert into tb_detalle_venta values('V002', 'P019', 1, 15.90);
insert into tb_detalle_venta values('V002', 'P003', 2, 466.60);


select max(num_venta), max(fec_Venta), cod_usu from tb_ventas where cod_usu = 'C001';
select * from tb_ventas;
select * from tb_usuario;



-- ACCESO DE UN CLIENTE
DELIMITER $$
create procedure sp_accesoUsuario(usr varchar(55), pas varchar(30))
begin
	select cod_usu, nombre, apellido, email, clave, cod_dis, direccion, telefono, DNI from tb_usuario 
    where email = usr and clave = pas;
end
$$ DELIMITER ;

call sp_accesoUsuario('xasasas', 'xd');


-- DEVUELVE EL HISTORIAL DE VENTAS DE UN CLIENTE
DELIMITER $$
create procedure sp_historial(codigo char(4))
begin
	select v.fec_Venta, dv.cod_prod, dv.cant_prod, dv.subtotal
    from tb_ventas v inner join tb_detalle_venta dv
    on v.num_venta = dv.num_venta
    where v.cod_usu = codigo;
end
$$ DELIMITER ;

-- DEVUELVE EL HISTORIAL DE VENTAS DE UN CLIENTE Y POR UNA VENTA
DELIMITER $$
create procedure sp_historial_x_venta(codigo char(4), venta char(4))
begin
	select v.fec_Venta, dv.cod_prod, dv.cant_prod, dv.subtotal
    from tb_ventas v inner join tb_detalle_venta dv
    on v.num_venta = dv.num_venta
    where v.cod_usu = codigo and v.num_venta = venta;
end
$$ DELIMITER ;

-- DEVUELVE EL HISTORIAL DE VENTAS DE UN CLIENTE POR FECHA
DELIMITER $$
create procedure sp_historial_fecha(codigo char(4), fecha date)
begin
	select v.fec_Venta, dv.cod_prod, dv.cant_prod, dv.subtotal
    from tb_ventas v inner join tb_detalle_venta dv
    on v.num_venta = dv.num_venta
    where v.cod_usu = codigo and v.fec_Venta = fecha;
end
$$ DELIMITER ;


call sp_historial('C001');
call sp_historial_fecha('C001', '2018-11-02');



-- TRAER LA ULTIMA VENTA REALIZADA POR UN CLIENTE
DELIMITER $$
create procedure sp_ultima_venta(nventa char(4), usuario char(4))
begin
	select v.fec_Venta, dv.cod_prod, p.descripcion, p.precio, p.marca, dv.cant_prod, dv.subtotal
    from tb_ventas v inner join tb_detalle_venta dv
    on v.num_venta = dv.num_venta inner join tb_producto p
    on dv.cod_prod = p.cod_prod
    where v.num_venta = nventa and v.cod_usu = usuario;
end
$$ DELIMITER ;

call sp_ultima_venta('V002', 'C001');



-- BUSCAR PRODUCTO POR DESCRIPCION (EJERICICIO AJAX)
DELIMITER $$
create procedure sp_buscar_productoXdesc(filtro varchar(50))
begin
	select cod_prod, descripcion from tb_producto where descripcion like concat('%',filtro,'%');
end
$$ DELIMITER ;

call sp_buscar_productoXdesc('');


-- LISTADO DE PRODUCTOS MAS VENDIDOS
DELIMITER $$
create procedure sp_productos_mas_vendidos()
begin
	select p.*, sum(dv.cant_prod) as cantidad_vendida from tb_producto p
    inner join tb_detalle_venta dv on p.cod_prod = dv.cod_prod
    group by p.cod_prod
    order by cantidad_vendida desc;
end
$$ DELIMITER ;

call sp_productos_mas_vendidos();


-- LISTADO DE CLIENTES QUE COMPRARON MAS
DELIMITER $$
create procedure sp_clientes_mas_compra()
begin
	select u.*, sum(dv.subtotal) as total_comprado from tb_usuario u
    inner join tb_ventas v on v.cod_usu = u.cod_usu
    inner join tb_detalle_venta dv on dv.num_venta = v.num_venta
    group by u.cod_usu
    order by total_comprado desc;
end
$$ DELIMITER ;

call sp_clientes_mas_compra();


-- VENTAS X USUARIO
DELIMITER $$
create procedure sp_ventas_x_usuario(usuario char(4))
begin
	select * from tb_ventas where cod_usu = usuario;
end
$$ DELIMITER ;


-- ACTUALIZAR PRODUCTO
DELIMITER $$
create procedure sp_actualizar_producto(codigo char(4), categoria char(4), descripcion varchar(100), marca varchar(20), uni_med varchar(30), stock_act int, stock_min int, precio decimal(10,2))
begin
	update tb_producto p set p.cod_cate = categoria, p.descripcion = descripcion, p.marca = marca, p.uni_med = uni_med, p.stock_act = stock_act, p.stock_min = stock_min, p.precio = precio where p.cod_prod = codigo;
end
$$ DELIMITER ;


















