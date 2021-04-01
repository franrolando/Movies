CREATE DATABASE movies
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
    
CREATE TABLE public.company
(
    id integer NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    address character varying COLLATE pg_catalog."default",
    value double precision,
    CONSTRAINT "Company_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.company
    OWNER to postgres;
    
CREATE TABLE public.gender
(
    id integer NOT NULL,
    description character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Gender_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.gender
    OWNER to postgres;
    
CREATE TABLE public.movie
(
    id integer NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    duration_in_minutes integer NOT NULL,
    release_date date NOT NULL,
    critic_review double precision,
    idcompany integer NOT NULL,
    CONSTRAINT "Movie_pkey" PRIMARY KEY (id),
    CONSTRAINT "COMPANYID" FOREIGN KEY (idcompany)
        REFERENCES public.company (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.movie
    OWNER to postgres;
    
CREATE TABLE public.script
(
    idmovie integer NOT NULL,
    id integer NOT NULL,
    times_modified integer,
    last_modified date NOT NULL,
    CONSTRAINT "Script_pkey" PRIMARY KEY (id),
    CONSTRAINT "IDMOVIE" FOREIGN KEY (idmovie)
        REFERENCES public.movie (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.script
    OWNER to postgres;
    
CREATE TABLE public.screenwriter
(
    idgender integer NOT NULL,
    id integer NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    age integer,
    CONSTRAINT "Screenwriter_pkey" PRIMARY KEY (id),
    CONSTRAINT "IDGENDER" FOREIGN KEY (idgender)
        REFERENCES public.gender (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.screenwriter
    OWNER to postgres;
    
CREATE TABLE public.screenwriter_movie
(
    idscreenwriter integer NOT NULL,
    idmovie integer NOT NULL,
    CONSTRAINT "IDSWMOV" PRIMARY KEY (idscreenwriter, idmovie),
    CONSTRAINT "IDMOVIE" FOREIGN KEY (idmovie)
        REFERENCES public.movie (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "IDSCREENWRITER" FOREIGN KEY (idscreenwriter)
        REFERENCES public.screenwriter (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.screenwriter_movie
    OWNER to postgres;
    
INSERT INTO public."company"(
	"id", "name", "address", "value")
	VALUES (1, 'Pixar', 'Calle falsa', '123'),
	(2, 'LucasFilm', 'Avenida siempreviva', '555'),
	(3, '"WarnerBros"', '9 "Calle random"', '333'),
	(4, 'Disney', '9 Julio', '12345');
	
INSERT INTO public."gender"(
	"id", "description")
	VALUES (1, 'Belico'),
	 (2, 'Terror'),
	 (3, 'Suspenso');
	
INSERT INTO public."movie"(
	"id", "name", "duration_in_minutes", "release_date", "critic_review", "idcompany")
	VALUES (1, 'Toy Story', 120, '2000-02-12', 10, 1),
	(2, 'Avengers', 130, '2017-10-02', 10, 3),
	(3, 'RyF', 485, '2010-08-10', 7, 1),
	(4, 'Star wars', 160, '2015-06-09', 9, 2),
	(5, '300', 154, '2012-05-13', 7, 1),
	(6, 'Shrek 2', 135, '2011-01-24', 6, 4);
	
INSERT INTO public."script"(
	"idmovie", "id", "times_modified", "last_modified")
	VALUES (2, 1, 21, '2000-12-31'),
	(1, 2, 34, '2000-02-22'),
	(4, 3, 12, '2010-04-26'),
	(6, 4, 25, '2012-08-10'),
	(3, 5, 16, '2007-05-17'),
	(5, 6, 30, '2017-11-05');
	
INSERT INTO public."screenwriter"(
	"idgender", "id", "name", "age")
	VALUES (1, 1, 'Pedro', 23),
	(2, 2, 'Tarantino', 65),
	(1, 3, 'Campanella', 70),
	(3, 4, 'Suthering', 23),
	(3, 11, 'Francella', 48),
	(2, 5, 'Rowling', 62),
	(3, 6, 'Pagani', 87),
	(1, 7, 'Buzz lightyear', 30),
	(1, 8, 'Omen', 54),
	(1, 9, 'Viktor', 43),
	(2, 10, 'Malphite', 32);
	
INSERT INTO public."screenwriter_movie"(
	"idscreenwriter", "idmovie")
	VALUES (1, 4),
	(1, 2),
	(2, 3),
	(3, 6),
	(3, 5),
	(4, 3),
	(4, 1),
	(4, 2),
	(5, 4),
	(6, 2),
	(6, 3),
	(7, 1),
	(7, 6),
	(8, 4),
	(8, 5),
	(9, 5),
	(10, 3),
	(11, 1);