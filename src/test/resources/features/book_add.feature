Feature: add book

  Scenario: add book
    Given a system with an empty books repository
#    And an authorized client
    And a book with following details
      | id   | name | isbn | author | pages |
      | id_1 | BDD  | 1234 | JG     | 190   |
    When client adds the book
    Then response should be
    """
    {
      "message": "Book created successfully",
      "book": {
        "id": "some-random-id",
        "name": "BDD/TDD",
        "isbn": "1234",
        "author": "JG",
        "pages": 190
      }
    }
    """