## Assumption
<p> Before run the application made some assumption 
 <p>1. Grid size is 6x6 </p>
 <p>2. Starting point is X=1 and Y=1 </p>
 <p>3. initial direction is EAST </p>
 <p>4. obstacles are at X=2,Y=2 and X=3,Y=3 </p>
 <p>5. Output is summary of the co-ordinates visited.Here if probe faced obstacles those co-ordinates are not displayed </p>

 
## Submersible-probe
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

## Output
<p> (1 , 1)(2 , 1)(1 , 1) </p>

## Requirements 
<P>• You have a defined grid representing the ocean floor where location can be identified using x/y co-ordinates
<p>• You are given an initial starting point (x, y) for the probe and the direction it is facing
<p>• The probe will receive a collection of commands
<p>• It should be able to:
<p>o Move forwards and backwards
<p>o Turn left and right
<p>o Stay on the grid
<p>o Avoid obstacles in the grid
<p>o Print a summary of the co-ordinates visited

## Run any of the  below command to see the test report
 <p> mvn clean install 
 <p>  mvn clean test jacoco:report
 <p>  mvn clean verify
 <p>  mvn -Dtest=SubmersibleProbeJunitTest test
 <p>  mvn -Dtest=SubmersibleProbeIntegrationTests test
   
 <p>  test report location : target/site/jacoco/index.html
