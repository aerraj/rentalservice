# Rental Service System

A rental service system that manages multiple branches throughout the city, each with a limited number of different kinds of vehicles. The system supports vehicle booking with predefined prices per unit time slot and ensures bookings are made before the start time. The system includes functionality for onboarding new branches and vehicles, renting vehicles, and providing a system view.

## Functional Requirements

1. **Branch Management**
   - **Onboard New Branch**: Add a new branch to the system with details such as branch name, location, and available vehicles.

2. **Vehicle Management**
   - **Onboard New Vehicles to Existing Branch**: Add new vehicles of an existing type to a specific branch.
   - **Update the inventory of vehicles in the branch**.

3. **Booking Management**
   - **Book a Vehicle**: Users can book a vehicle for a specific time slot (multiples of 1 hour).
   - **Booking Constraints**: Bookings should be made before the start time of the desired booking period.
   - **Default Booking Strategy**: Choose the vehicle with the lowest price per hour.
   - **Fallback Strategy**: If the selected vehicle is unavailable, the system should fallback to another available branch based on the vehicle selection strategy.

4. **Pricing Management**
   - **Fixed Pricing Model**: Prices for vehicles are predefined and fixed. The system does not support dynamic pricing or seasonal price adjustments.

5. **System View**
   - **View System Status**: Provide a view of currently blocked (booked) vehicles across all branches, including information such as branch name, vehicle type, booking duration, and price per hour.

## Technology Stack

- **Java Version**: 17
- **Spring Boot Version**: 3
- **Dependencies**:
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Web
  - Spring Boot DevTools
  - H2 Database

## UML Class Diagram

  ![image](https://github.com/user-attachments/assets/34a89ccb-cdf2-406d-a811-bcd989743f80)
