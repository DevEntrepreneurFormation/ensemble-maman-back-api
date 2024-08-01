DROP TABLE IF EXISTS donations;
CREATE TABLE donations (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  image_url VARCHAR(250) NOT NULL,
  quantity INT NOT NULL,
  gender ENUM('BOYS', 'GIRLS', 'MIXTED') NOT NULL,
  book_title VARCHAR(250),       -- Spécifique à Book
  state ENUM('NEW', 'GOOD_STATE'), -- Spécifique à Clothe
  size ENUM('ONE_MONTH', 'THREE_MONTH', 'SIX_MONTH', 'NINE_MONTH', 'TWELVE_MONTH', 'EIGHTEEN_MONTH', 'TWENTY_FOUR_MONTH', 'THREE_YEARS', 'FOUR_YEARS', 'FIVE_YEARS', 'SIX_YEARS', 'SEVEN_YEARS', 'EIGHT_YEARS', 'NINE_YEARS', 'TEN_YEARS', 'ELEVEN_YEARS', 'TWELVE_YEARS'), -- Spécifique à Clothe
  type_donation VARCHAR(250) NOT NULL
);

INSERT INTO donations (name, image_url, quantity, gender, book_title, type_donation)
VALUES ('Donation Livre', 'https://example.com/image3.jpg', 3, 'GIRLS', 'Harry Potter', 'BOOK');

INSERT INTO donations (name, image_url, quantity, gender, state, size,type_donation)
VALUES ('Donation Vêtement', 'https://example.com/image4.jpg', 2, 'BOYS', 'NEW', 'SIX_YEARS', 'CLOTHE');