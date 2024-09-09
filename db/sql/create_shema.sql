-- public.category definition

-- Drop table

-- DROP TABLE public.category;

CREATE TABLE public.category (
	id serial4 NOT NULL,
	description text NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT category_pkey PRIMARY KEY (id),
	CONSTRAINT category_unique UNIQUE (name)
);

-- public.clientes definition

-- Drop table

-- DROP TABLE public.clientes;

CREATE TABLE public.clientes (
	id uuid NOT NULL,
	"name" varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	numerocel varchar(10) NULL,
	direccionenvio varchar(100) NULL,
	tipoid bpchar(2) NULL,
	"document" varchar(20) NOT NULL,
	CONSTRAINT clientes_document_key UNIQUE (document),
	CONSTRAINT clientes_email_key UNIQUE (email),
	CONSTRAINT clientes_pkey PRIMARY KEY (id)
);

-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	id uuid NOT NULL,
	price int4 NULL,
	stock int4 NULL,
	categoryfk int4 NULL,
	"name" varchar NOT NULL,
	description varchar NULL,
	available bool NULL,
	CONSTRAINT product_pk PRIMARY KEY (id),
	CONSTRAINT product_unique UNIQUE (name)
);

-- public.pedidos definition

-- Drop table

-- DROP TABLE public.pedidos;

CREATE TABLE public.pedidos (
	id uuid NOT NULL,
	creationdatetime timestamp NOT NULL,
	quantity int4 NULL,
	extrainformation varchar(511) NULL,
	clientefk uuid NULL,
	combofk uuid NULL,
	CONSTRAINT pedidos_pkey PRIMARY KEY (id)
);


-- public.pedidos foreign keys

ALTER TABLE public.pedidos ADD CONSTRAINT pedidos_clientefk_fkey FOREIGN KEY (clientefk) REFERENCES public.clientes(id);