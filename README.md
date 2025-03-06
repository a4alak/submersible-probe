# submersible-probe
Request Json Body :
http://localhost:8080/api/v1/movetheprobe

{
  "gridSizeX": 6,
  "gridSizeY": 6,
  "startX": 1,
  "startY": 1,
  "initialDirection": "EAST",
  "obstacles": [[2,2], [3,3]],
  "commands": ["FORWARD", "RIGHT", "FORWARD", "FORWARD", "LEFT", "BACKWARD"]
    
}
