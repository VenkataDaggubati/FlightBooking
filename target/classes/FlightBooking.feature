Feature: Flight ticket booking applications
  I want to use this template for my feature file

  @assessment
  Scenario Outline: Book cheapest Business class tickets for 4 Passengers round trip journey 
    Given User launches flight booking application <applicationUrl> 
    And User selects trip type and cabin as <tripType> and <cabinType>
    And User select origin and destination as <origin> and <destination>
    And User selects travel dates <tripType> 
    And User selects passengers as <passengerType> 
    And User selects airlines and flight Type as <airLine> and <flightType> 
		And User selects fare Type as <fareType>
	
    Examples: 
      | applicationUrl  					| tripType | cabinType | origin | destination | passengerType       | airLine         | flightType | fareType   |
      | https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Basic      |
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Flex       |
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Super Flex |
    #
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Fastest    | Basic      |
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Fastest    | Flex       |
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Fastest    | Super Flex |
      #
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Best    | Basic      |
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Best    | Flex       |
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Best    | Super Flex |
      #
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | Air France | Best    | Basic      |
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | Air France | Best    | Flex       |
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-2,Children-2 | Air France | Best    | Super Flex |
      #
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-3 | Air France | Fastest    | Basic      |
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-3 | Air France | Fastest    | Flex       |
      #| https://www.opodo.co.uk/  | Return   | Business  | LHR    | CDG         | Adults-3 | Air France | Fastest    | Super Flex |
      #
      #| https://www.opodo.co.uk/  | Return   | Economy  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Basic      |
      #| https://www.opodo.co.uk/  | Return   | Economy  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Flex       |
      #| https://www.opodo.co.uk/  | Return   | Economy  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Super Flex |
      #
      #| https://www.opodo.co.uk/  | Return   | Premium economy  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Basic      |
      #| https://www.opodo.co.uk/  | Return   | Premium economy  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Flex       |
      #| https://www.opodo.co.uk/  | Return   | Premium economy  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Super Flex |
      #
     #	| https://www.opodo.co.uk/  | One way   | Economy  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Basic      |
      #| https://www.opodo.co.uk/  | One way   | Economy  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Flex       |
      #| https://www.opodo.co.uk/  | One way   | Economy  | LHR    | CDG         | Adults-2,Children-2 | British Airways | Cheapest   | Super Flex |