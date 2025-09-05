# Fiche de spécification API Loveling Website

## Récupération de donnée

### GET /products/

- **Description** : Retourne tous les produits.
- **Méthode** : `GET`
- **URL** : `/products/`
- **Paramètre d’URL** : `-`
- **Corps de la requête (JSON)** : `-`
- **Réponse attendue (JSON)** :
```json
[
  {
    "id" : "1122-fq2qf-fq32q",
    "name" : "Produits 1",
    "collection" : "collection name"
  }
]
```
- **Code HTTP atendu** : `200 OK`
- **Code d'erreur possible** :
    - `500 Internal Server Error`


### GET /products/`{id}`

- **Description** : Retourne le produit ayant l'identifiant (`id`).
- **Méthode** : `GET`
- **URL** : `/products/{id}`
- **Paramètre d’URL** :
    - `id` (string) : identifiant unique du post à récupérer
- **Corps de la requête (JSON)** : `-`
- **Réponse attendue (JSON)** :
```json
{
  "id" : "1122-fq2qf-fq32q",
  "name" : "Produits 1",
  "collection" : "collection name",
  "description" : "description du produits",
  "year" : "date de création du produit",
  "composition" : "composition du produits"
}
```
- **Code HTTP atendu** : `200 OK`
- **Code d'erreur possible** :
    - `400 Bad Request`
    - `404 Not Found`
    - `500 Internal Server Error`

### GET /products/search

- **Description** : Retourne la liste des résultats correspondant aux filtres..
- **Méthode** : `GET`
- **URL** : `/products/`
- **Paramètre d’URL** : `-`
- **Corps de la requête (JSON)** :
```json
{
  "name" : "name",
  "collection" : "collection name",
  "year" : "année de sortie"
}
```
- **Réponse attendue (JSON)** :
```json
[
  {
    "id" : "1122-fq2qf-fq32q",
    "name" : "Produits 1",
    "collection" : "collection name"
  }
]
```
- **Code HTTP atendu** : `200 OK`
- **Code d'erreur possible** :
    - `400 Bad Request`
    - `500 Internal Server Error`

## Création de donnée

`A venir`

## Modification/Suppression de donnée

`A venir`

## Suppression de donnée

`A venir`