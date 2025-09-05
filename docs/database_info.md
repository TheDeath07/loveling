# Documentation de la Base de Données

## 📌 Informations générales
- **Nom de la base** : `loveling_db`
- **SGBD utilisé** : PostgreSQL 15
- **Auteur** : R.S.G.
- **Date de création** : 2025-09
- **Description** : Cette base gère les produits, les utilisateurs et les rejets lié au domaine loveling.

---

## 📂 Schéma global

### Def
- **PK** : Primary Key
- **FK** : Foreign Key

---

### Product
| Name          | Type          | Constraint           | Description                             |
|---------------|---------------|----------------------|-----------------------------------------|
| Id            | Varchar (10)  | Not null, PK         | Unique key to represent the product     |
| Name          | Varchar (20)  | Not null             | The name of the product                 |
| Collection    | Varchar (20)  | FK -> collection(id) |
| Description   | Text          |                      | The description of the product          |

### Collection
| Name | Type        | Constraint | Description                             |
|------|-------------|------------|-----------------------------------------|
| Id   | Varchar(10) | PK         |
| Name | Varchar(30  | Not null   |
| Year | Int         | Not null   |

### Ingredients
| Name             | Type        | Constraint   | Description                            |
|------------------|-------------|--------------|----------------------------------------|
| Id (Primary Key) | Varchar(10) | Not null, Pk | Unique key to represent the ingredient |
| Name             | Varchar(20) | Not null     | The name of the ingredient             |

### Composition
| Name          | Type        | Constraint                         | Description                  |
|---------------|-------------|------------------------------------|------------------------------|
| product_id    | Varchar(10) | Not null, PK, FK -> product(id)    | Unique key of the product    |
| ingredient_id | Varchar(10) | Not null, PK, FK -> ingredient(id) | Unique key of the ingredient |
| quantity      | Long        |                                    | The percentage per liter     |


### User
| Name      | Type         | Constraint       | Description                      |
|-----------|--------------|------------------|----------------------------------|
| Id        | varchar (10) | Not null, PK     | Unique key to represent the user |
| Fist_name | Varchar(20)  | Not null         |
| Last_name | Varchar(20)  | Not null         |
| Email     | Varchar(35)  | Not null, Unique |

### Login
| Name     | Type         | Constraint                      | Description       |
|----------|--------------|---------------------------------|-------------------|
| Email    | Varchar (35) | Not null, PK, FK -> user(email) | Email of the user |
| Password | Varchar      | Not null                        |

### Role
| Name | Type         | Constraint | Description |
|------|--------------|------------|-------------|
| Id   | Long         | PK         |
| Name | Varchar (15) | Unique     |

### User_role
| Name    | Type         | Constraint         | Description |
|---------|--------------|--------------------|-------------|
| Role_id | Long         | PK, FK -> role(id) |
| User_id | Varchar (35) | PK, FK -> user(id) |

### Reject
| Name      | Type        | Constraint | Description |
|-----------|-------------|------------|-------------|
| UUID      | Varchar(10) | Not null   |
| User_name | Varchar(20) | Not null   |
| Origin    | Varchar(20) | Not null   |
| Error     | Json        | Not null   |
| Content   | Json        | 