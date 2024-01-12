DROP TABLE IF EXISTS "books";
DROP TABLE IF EXISTS "authors";

CREATE SEQUENCE authors_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE "authors" (
    "id" BIGINT DEFAULT NEXTVAL('authors_id_seq') NOT NULL,
    "name" TEXT,
    "age" INTEGER,
    CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);

CREATE TABLE "books" (
    "isbn" TEXT NOT NULL,
    "title" TEXT,
    "author_id" BIGINT,
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"),
    CONSTRAINT "fk_author" FOREIGN KEY ("author_id") REFERENCES "authors" ("id")
);
