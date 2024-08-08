package com.ensemblemaman.api.model;

public class ConstantDonation {

    public enum TypeDonationEnum {
      TOY,
      CLOTHES,
      HYGIENE  
    }

    public enum GenderEnum{
      BOYS,
      GIRLS,
      MIXED
    } 
// Toy enum start 

    public enum AgeEnum{
      ONE_YEAR_AND_LESS,
      THREE_YEARS,
      SIX_YEARS,
      TEN_YEARS_AND_MORE
    }

// Toy enum end
// Clothe enum start 
    public enum SizeEnum{
      ONE_MONTH,
      THREE_MONTH,
      SIX_MONTH,
      NINE_MONTH,
      TWELVE_MONTH,
      EIGHTEEN_MONTH,
      TWENTY_FOUR_MONTH,
      THREE_YEARS,
      FOUR_YEARS,
      FIVE_YEARS,
      SIX_YEARS,
      EVEN_YEARS,
      EIGHT_YEARS,
      NINE_YEARS,
      TEN_YEARS,
      ELEVEN_YEARS,
      TWELVE_YEARS
    }
// Clothe enum end 
    
    public enum StateEnum{
      NEW,
      GOOD_STATE
    }

    public enum HygieneCategoryEnum {
      BATH_PRODUCTS,
      SKIN_CARE,
      DIAPERING_PRODUCTS,
      HAIR_CARE,
      ORAL_HYGIENE,
      NAIL_CARE,
      EAR_AND_NOSE_CARE,
      BATH_ACCESSORIES,
      WELLNESS_AND_GROOMING_PRODUCTS;
  }

}
