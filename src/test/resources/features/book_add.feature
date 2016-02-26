Feature: add book

  Scenario: add book
    Given a book with following details
      | name | isbn | author | pages |
      | BDD  | 1234 | JG     | 190   |
    When I add it
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