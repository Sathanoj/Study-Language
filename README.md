# 📦 Flashcard Project - Paper Box & Flash Card Tables

First start docker compose whith:

```
  docker compose up -d
```


## 🛠️ Database Setup

Before start project run these SQL commands to create the necessary tables:

```
CREATE TABLE paper_box (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date TIMESTAMP
);

CREATE TABLE flash_card (
    id SERIAL PRIMARY KEY,
    word VARCHAR(255) NOT NULL,
    word_translated VARCHAR(255) NOT NULL,
    date TIMESTAMP,
    paper_box_id INT NOT NULL,
    CONSTRAINT fk_paper_box
        FOREIGN KEY (paper_box_id)
        REFERENCES paper_box(id)
        ON DELETE CASCADE
);

```
Now, start the project. For better use of the API, you will need applications like Post or Insomnia.
