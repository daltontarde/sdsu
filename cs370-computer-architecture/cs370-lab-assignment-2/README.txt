Group Members: John Fox and Dalton Tarde

Files:
 - ECC Generator.cct: ECC Generator
 - 13-Bit Data Transmission BUS.cct: 13-Bit BUS
 - Big C/C#.cct: Calculation of Big C and parity bits
 - Big P.cct: Calculation of Big P
 - 3-8 Decoder.cct: Abstraction of a 3-8 Decoder (not the LogicWorks preset)
 - 4-16 Decoder.cct: Abstraction of a 4-16 Decoder (not the LogicWorks preset)
 - Main Memory.cct: Main memory includes non-preset decoders, Big C/P calculations, and error checking of bits
All stored in HammingCode.clf

 - TestCircuit.cct: Circuit with all parts from HammingCode.clf

Contributions:
We collaborated on all parts together in a Discord call. Names below are who did more work for certain parts of Lab 2.
 1) ECC Generator.cct: Dalton Tarde
 2) 13-Bit Data Transmission BUS: John Fox 
 3) Big C/C#: John Fox   
 4) Big P: Dalton Tarde
 5) 3-8 Decoder: Dalton Tarde
 6) 4-16 Decoder: John Fox 
 7) Main Memory: John Fox 
 8) TestCircuit: John Fox
 9) README: Dalton Tarde 
 
Documentation:
ECC: The ECC (Error Correction Code) Generator part accepts 8 inputs (bits) and calculates the four parity bits of the inputs using XOR gates. The five parity bits are calculated using even parity, and are output with together with the 8 input bits to form a 13-bit vector

13-Bit BUS: The BUS/data transfer part will transmit the 13-bits from the ECC generator (8 inputs and 4 parity bits) . It will also take in 13 bits to simulate bit flip errors for the ECC detector part

Big C/C#: Calculates Big C using an OR of All C's

Big P: Calculates Big P using a XOR of all 13 bits 

3-8 Decoder: Created a 3-8 Decoder since as a group we were finding logical issues with the base decoder in Logicworks - used for abstraction

4-16 Decoder: Created a 4-16 Decoder for input of data from the BUS - similar abstraction in our Main Memory file

Main Memory: Main Memory involves multiple parts, and will read the 13 input bits from the BUS and figure out if any changes occurred by checking the parity bits. This check will work out whether a bit flip has been detected. Up to 2 bit flips are able to be documented

Test Circuit: Test Circuit uses bit switches and hex displays to test all parts found in HammingCode.clf 