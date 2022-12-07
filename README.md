# CMPE202_Individual_Project
## Design Patterns:

### Factory Design Pattern
![alt-text](https://github.com/jsourya/CMPE202_Individual_Project/blob/main/IndividualProject/images/image_2022_12_07T04_34_48_006Z.png)
### Strategy Design Pattern

![alt-text](https://github.com/jsourya/CMPE202_Individual_Project/blob/main/IndividualProject/images/image_2022_12_07T04_42_59_857Z.png)
- Describe what is the primary problem you try to solve.
  - The main problem we are trying to solve is that we need to identify the type of the file format (i.e, json , csv or xml) and read it to find the cardNumber from the input file and checking each number to be valid or invalid based on Luhn's algorithm( self-chosen). Furthermore, we need to identify the type fo acrd i.e, MasterCard, Visa or Discover based on the validations given in problem structure. Ther should be specific design pattern followed inorder to figure out what kind of card a specific record is about, the other one with how you create the appropriate objects.
  

- Describe what are the secondary problems you try to solve (if there are any).
  - The secondary problem is to identify the card is valid or invalid according to a algorithm, here I have chosen Luhn's algorithm for the same. There is another problem to be resolved that is to write the type of card if valid into specific file formats in which it comes in.

- Describe what design pattern(s) you use how (use plain text and diagrams).
  - I have used Strategy design pattern to know the file format input file comes in(JSON, CSV, XML). It also allows to use this implementation in the future for newer file formats.In this patter, we encapsulate the Parser interface deatils and hide the implementation details in the derived classes (CSVParser, XMLParser, JSONParser). After parsing these, we extract the card number from the input files and now we need to identify the type of the credit card that is the MasterCard, Visa, Discover( by matching the regular expressions) . For identifying the type of card, we use the Factory Design pattern. This is done by using CardFactory class object for the Card class. Based on the argumnets given it creates the particular credit  card type.

- Describe the consequences of using this/these pattern(s).
  - 
