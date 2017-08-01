# KNW Robot Design Challenge: The Search for Life on Zoltan

Ryan Reynolds, Carter Koehler, Patrick Yienger, Avi Sinha, Jamie Paterson, Matthew Lee

## Introductions

**Our Team:** Team of SMU engineering students that hail from different backgrounds.

**The Problem** : The potential for the discovery of extraterrestrial life in our solar system.

**Short Term Impacts of Potential Discovery**

●  Call into question existing knowledge of our solar system.

●  Cause existing scientific theories to be amended.

●  Lead to more questions being posed to NASA.

**Long Term Impacts of Potential Discovery**

●  Lead to an increase in interest of space travel.

●  Lead to the development of a Universal Biology.

●  Lead to a massive increase of funding for NASA .

**Potential Impacts of Failure**

●  May lead to a decrease in the interest of space travel.

●  May lead to no major developments in accepted science.

●  May lead to a decrease in funding for NASA.

## Our Task

**Autonomous Robot Rover**

All of the rover functions will fall under the categories of software and hardware.

- Navigation
- Sensors

**Bridge**

- Support

## Software: Object Oriented Design

**Making Robot class from RXTX Robot**

●  More efficient

●  Organized setup

**Encapsulation**

●  Clarity

●  Have simple access to RXTX

●  Allow higher level development

Constructor sets up arduino and attaches motor/ servos

Sleep, run motor, analog pin data methods

Removes need to directly access RXTX

Allows us to modify the building blocks at a higher level

### General Code Design

Take track of the motor; while it did not reach the desired distance; If it an object is detected it stops and waits for 7 seconds; then if it&#39;s still there it does the static object maneuver; and continues for the rest of the distance

**Sequential directions**

- Side change
- Order of movement
- Order of tasks

Take track of the motor; while it did not reach the desired distance; if it an object is detected it stops and waits for 7 seconds; then if it&#39;s still there it does the static object maneuver; and continues for the rest of the distance

**Dynamic and Static Obstacle Avoidance**

- Until reached
- Only move when no obstacle present.
- Keep waiting
- Or evade if static

## Calibration

R-squared and the reliability of each graph

Temperature/anemometer boom

- Capable of raising 135cm off the surface of Zoltan
- Sensors: High Accuracy, Precision could have been improved

Potential surface level wind blockers, how our design circumvents this problem. Demo possibly

Boom raised to the effective height 49/50 initiations. A loose screw caused the single failure, easily fixable and not a design flaw.

Sensors could read wind/temp within 5% of actual value. The issue of the thermistor heating up the ping pong ball affected precision

Video, Use of rubber bands gave easily replaceable traction enhancement. Dynamic avoidance, and using the walls for raised platform recognition.

Video, avoids issues with contact with walls, and impacts loosening connections.

Issues with calibration/battery charge. Discuss calibrating at several different voltage levels, allowing easy switch ups with a quick voltage test.
