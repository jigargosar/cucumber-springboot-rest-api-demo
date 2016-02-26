Feature: delete book

  Scenario: delete a book
    Given a book repository with following books
      | id  | name | isbn | author | pages |
      | aaa | BDD  | 1234 | JG     | 190   |
      | bbb | TDD  | 9876 | KB     | 320   |
    When I delete the book with id "aaa"
    Then response should be
    """
    {
      "message": "Book created successfully",
      "book": {
        "id": "aaa",
        "name": "BDD/TDD",
        "isbn": "1234",
        "author": "JG",
        "pages": 190
      }
    }
    """