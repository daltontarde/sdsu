Created by: Dalton Tarde

16-BitLock.cct: Part contains the given lock from CS-370 Lecture 14. The lock will take in 16 digits of user input before returning a 0 and stopping input from
the generated SPDT Pushbuttons

Sequencer.cct: Uses logic (Circle Diagram -> State Table -> K-Map) and 3 flip flops in order to save progress while traversing the 16 input bits and throw a 0 or a 1 (as z) depending on if the input is correct/incorrect.
I believe I did not have the proper logic in my k-maps, so my circuit unfortunately throws x's and does not properly display a 1. Everything except for the logic leading 
up to the flip flops should be 100% correct though. I'll be sure to look more into which proper gates to use for repeating numbers, since I ran into issues with that here.
Thanks for coming through here and grading TA's - sorry I couldn't get it 100% functioning and I attached my design pdf to the zip so you can see where it went wrong.

Lab3TestCircuit.cct: Test circuit contains both the 16-BitLock and the Sequencer in order to display the proper 0/1 depending on user input, and also limit input at 16 binary bits.

GottchaAntiTheft.cct: This part facilitates user input through two SPDT Pushbuttons and voltage, and then runs it through the Lab3TestCircuit (named Gottcha), in order to display
a 0 or a 1 on a binary probe.

DTarde.clf: Library containing all parts listed above. 