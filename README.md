## Assumption

## submersible-probe
<p>Request Json Body :
<p>http://localhost:8080/api/v1/movetheprobe
<p>
{
 <p> "gridSizeX": 6,
 <p>"gridSizeY": 6,
 <p>"startX": 1,
 <p>"startY": 1,
 <p>"initialDirection": "EAST",
 <p>"obstacles": [[2,2], [3,3]],
 <p>"commands": ["FORWARD", "RIGHT", "FORWARD", "FORWARD", "LEFT", "BACKWARD"]
<p>    
}


Requirements • You have a defined grid representing the ocean floor where location can be identified using x/y co-ordinates
• You are given an initial starting point (x, y) for the probe and the direction it is facing
• The probe will receive a collection of commands
• It should be able to:
o Move forwards and backwards
o Turn left and right
o Stay on the grid
o Avoid obstacles in the grid
o Print a summary of the co-ordinates visited
