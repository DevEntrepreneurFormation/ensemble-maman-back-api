DROP TABLE IF EXISTS donation;

CREATE TABLE donation (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  image_url VARCHAR(500) NOT NULL,
  quantity INT NOT NULL,
  gender ENUM('BOYS','GIRLS','MIXED'),
  state ENUM('GOOD_STATE','NEW'),
  age ENUM('ONE_YEAR_AND_LESS','THREE_YEARS','SIX_YEARS','TEN_YEARS_AND_MORE'),
  size ENUM(
          'ONE_MONTH',
          'THREE_MONTH',
          'SIX_MONTH',
          'NINE_MONTH',
          'TWELVE_MONTH',
          'EIGHTEEN_MONTH',
          'TWENTY_FOUR_MONTH',
          'THREE_YEARS',
          'FOUR_YEARS',
          'FIVE_YEARS',
          'SIX_YEARS',
          'EVEN_YEARS',
          'EIGHT_YEARS',
          'NINE_YEARS',
          'TEN_YEARS',
          'ELEVEN_YEARS',
          'TWELVE_YEARS'
      ),
  category ENUM(
      'BATH_PRODUCTS',
      'SKIN_CARE',
      'DIAPERING_PRODUCTS',
      'HAIR_CARE',
      'ORAL_HYGIENE',
      'NAIL_CARE',
      'EAR_AND_NOSE_CARE',
      'BATH_ACCESSORIES',
      'WELLNESS_AND_GROOMING_PRODUCTS'
      ),
  date_expiration VARCHAR(250),
  type_donation ENUM('HYGIENE','CLOTHE','TOY') NOT NULL
);

INSERT INTO donation(name, image_url, quantity, gender, state, age,type_donation)
VALUES 
('T-shirt', "https://www.google.com/search?sca_esv=00654281386d64e7&sca_upv=1&sxsrf=ADLYWIJvYR16z4dst1hI9dyl1xBXxwtazw:1722882041970&q=tshirt&udm=2&fbs=AEQNm0Aa4sjWe7Rqy32pFwRj0UkWd8nbOJfsBGGB5IQQO6L3J_TJ4YMS4eRay1mUcjRHkZwkNnuzbvXdHSnZt8SI-ypec-U-KajbXe9hbStxnPJuWyGzFd9gw7bs_5erv4JqgVwaohgK2B30rDwlMA7cSO6uCGX2skDYjrPcNyxQ0LFSyDB6WwKx36rvyWOFwdDagVlo_oTu&sa=X&ved=2ahUKEwjD2ufgu96HAxXWVUEAHVhbEAEQtKgLegQIFRAB&biw=1440&bih=813&dpr=2#vhid=1kQREOudLlEDmM&vssid=mosaic",5,"BOYS","GOOD_STATE","THREE_YEARS","CLOTHE");


INSERT INTO donation(name, image_url, quantity, gender, state,age, type_donation)
VALUES 
('Pirate des caraibes', "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.fr%2FPIRATES-CARIBBEAN-Action-AUG202096-Multicolore%2Fdp%2FB08WHH94Z1&psig=AOvVaw0ZGr4Rrj1skocWu11225oN&ust=1722970144767000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCICel43C3ocDFQAAAAAdAAAAABAE",3,"BOYS","GOOD_STATE","THREE_YEARS","TOY");