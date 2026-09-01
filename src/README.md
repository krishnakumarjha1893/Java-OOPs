
Conversation with Gemini
bhai last wala project lka detailing de bnana suru krta hun quick ride wala

QuickRide project ka standard clean architecture blueprint yeh raha, jisse tu step-by-step code likhna start kar sakta hai:

1. Package & Folder Structure
Plaintext
src/
└── com/
    └── quickride/
        ├── MainApp.java
        ├── model/
        │   ├── vehicle/
        │   │   ├── Vehicle.java           (Base class)
        │   │   ├── Car.java
        │   │   └── Bike.java
        │   ├── User.java                  (Rider/Driver)
        │   ├── Ride.java                  (Booking details)
        │   └── RideStatus.java            (Enum: REQUESTED, ONGOING, COMPLETED, CANCELLED)
        ├── repository/
        │   ├── VehicleRepository.java     (In-memory / DB CRUD)
        │   ├── UserRepository.java
        │   └── RideRepository.java
        └── service/
            ├── VehicleService.java        (Vehicle register/availability logic)
            ├── RideService.java           (Fare calculation, ride matching, booking)
            └── UserService.java
2. Core Class Details
Vehicle.java (Abstract / Base Model)

Fields:

vehicleId (String / Long)

vehicleNumber (String)

modelName (String)

perKmRate (double)

isAvailable (boolean)

Methods:

Getters / Setters, toString()

calculateFare(double distanceKm) (Car/Bike apne according override kar sakte hain)

Car.java / Bike.java (Extends Vehicle)

Specific attributes (e.g., seatingCapacity for Car, hasHelmetIncluded for Bike).

Ride.java

Fields: rideId, userId, vehicleId, source, destination, distanceKm, totalFare, status.

3. Service Layer Business Logic
VehicleService:

addVehicle(Vehicle vehicle)

getAvailableVehicles()

updateAvailability(String vehicleId, boolean status)

RideService:

bookRide(String userId, String vehicleId, double distance)

completeRide(String rideId)

calculateFare(Vehicle vehicle, double distance)

Pehle Vehicle.java ka code model ready karein ya direct service logic se start karein? Bata, main code snippet provide karta hun.

bhai eska ek docoment bna ke de taki main apne bachon ko assoignment bna ke dun tu n ese detail me apne sare expetaion aur main ke function sb aur architectiure layput bluprint folder structure sb de

Your PDF file is ready

PDF icon
QuickRide_Assignment_Specification
 PDF 
Assignment Overview Summary
Students ko dene ke liye comprehensive assignment document ready kar diya hai. Document ke key highlights:

Folder & Package Architecture:

com.quickride.model.vehicle (Vehicle, Car, Bike)

com.quickride.repository (VehicleRepository, UserRepository, RideRepository)

com.quickride.service (RideService, VehicleService, UserService)

com.quickride.exception (VehicleNotAvailableException, EntityNotFoundException)

MainApp.java (Console Controller/Menu)

Core OOPs & Business Logic Requirements:

Polymorphism & Abstraction: Base Vehicle class ke abstract method calculateFare(distance) ko Car aur Bike apne-apne tariff rules ke according override karenge.

Layered Decoupling: Repositories in-memory collections (HashMap/ArrayList) handle karenge, Services business rules enforce karenge, aur MainApp sirf CLI menu and user prompts run karega.

Interactive Console Flows:

Vehicle onboard karna, live available vehicles list karna, ride booking, fare calculation with ride completion, aur trip history check karna.

100-Marks Rubric:

OOP Principles (25 marks), Layered Architecture (20 marks), Collections (15 marks), Custom Exceptions (15 marks), CLI Experience & Code Quality (15 marks), aur Bonus Features (10 marks).



🚀 Key Features & OOP Concepts
Polymorphic Fare Calculation:

Vehicle provides an abstract contract calculateFare(double distanceKm).

Car and Bike classes override fare calculation logic based on vehicle-specific pricing rules.

Layered Decoupled Design (3-Tier):

Presentation Layer: MainApp handles user interaction and menus.

Service Layer: Business rules, state transitions, and fare validations.

Repository Layer: Pure data access using Java Collections (HashMap, ArrayList).

Custom Exceptions:

Robust error handling for invalid operations, entity lookups, and vehicle unavailability.

Finite State Machine:

RideStatus ensures strict trip lifecycle: REQUESTED ➔ ONGOING ➔ COMPLETED / CANCELLED.

🛠️ How to Compile & Run
Bash
# 1. Compile all Java source files
javac -d bin src/com/quickride/**/*.java src/com/quickride/*.java

# 2. Run the console application
java -cp bin com.quickride.MainApp
"""



Plaintext
QuickRide/
├── docs/
│   └── QuickRide_Assignment_Specification.pdf    <-- (Download karke yahan daal do)
├── src/
│   └── com/
│       └── quickride/
│           ├── MainApp.java
│           ├── model/
│           ├── repository/
│           └── service/
├── README.md                                     <-- (Github par project open hote hi dikhega)
└── .gitignore
Git Commands (Push karne ke steps):
Terminal/PowerShell open karke project ke root folder me chalao:

Bash
# 1. Git initialize karo (agar pehle se nahi kiya hai)
git init

# 2. Saari files add karo (src, docs, pdf, readme sab track ho jayega)
git add .

# 3. Commit karo
git commit -m "Initial commit: QuickRide core architecture, docs and assignment spec"

# 4. GitHub remote add karo aur push karo
git branch -M main
git remote add origin <APNA_GITHUB_REPO_URL>
git push -u origin main
Is tarah tumhare GitHub repository pe:

README.md frontend pe pura overview aur architecture render karega.

docs/ folder me PDF safe rahega jise future me kabhi bhi download ya view kiya ja sakta hai.

readnme ko 10 x jayda detail professional bnao pura sare method fied cllass package sb ka structure aur 10 x more professional with clear cut architecture and all map so that i can know flow every thing except code provide in readme

📁 Folder & Package Blueprint
Plaintext
QuickRide/
├── docs/
│   ├── QuickRide_Assignment_Specification.pdf    # Complete specification & rubric handout
│   └── architecture_diagram.png                  # System block diagram
├── src/
│   └── com/
│       └── quickride/
│           │
│           ├── MainApp.java                      # Interactive CLI menu orchestrator
│           │
│           ├── model/                            # Pure domain entities (No business logic)
│           │   ├── User.java                     # Rider & passenger domain entity
│           │   ├── Ride.java                     # Booking transaction aggregate model
│           │   ├── RideStatus.java               # State transition enum
│           │   └── vehicle/                      # Vehicle abstraction hierarchy
│           │       ├── Vehicle.java              # Abstract base vehicle entity
│           │       ├── Car.java                  # Concrete sedan/hatchback entity
│           │       ├── Bike.java                 # Concrete two-wheeler entity
│           │       └── Auto.java                 # Concrete three-wheeler entity (optional)
│           │
│           ├── repository/                       # In-memory CRUD & collection lookups
│           │   ├── VehicleRepository.java        # Fleet inventory repository
│           │   ├── UserRepository.java           # User profile storage
│           │   └── RideRepository.java           # Transaction & ride registry
│           │
│           ├── service/                          # Transactional business logic
│           │   ├── VehicleService.java           # Fleet status, query & registration rules
│           │   ├── UserService.java              # User registration & wallet operations
│           │   └── RideService.java              # Dispatch algorithm, lifecycle & pricing
│           │
│           └── exception/                        # Checked & unchecked failure domain
│               ├── VehicleNotAvailableException.java
│               ├── InvalidRideOperationException.java
│               └── EntityNotFoundException.java
│
└── README.md
🧩 Component & Class Specifications
1. Model & Domain Entities (com.quickride.model)
User.java
Purpose: Encapsulates rider personal identity, contact coordinates, and prepaid ledger.

Fields:

private String userId: Unique identifier (e.g., "USR-101").

private String fullName: Rider name.

private String phoneNumber: 10-digit contact number.

private double walletBalance: Prepaid monetary balance.

Methods:

public User(String userId, String fullName, String phoneNumber, double initialBalance)

Getters & Setters for all attributes.

public void deductBalance(double amount): Decrements wallet balance.

public void creditBalance(double amount): Tops up wallet balance.

public String toString(): Formats user profile summary for console printing.

Ride.java
Purpose: Aggregate entity recording a booking transaction, location vector, and state metadata .  
PDF
+ 1

Fields:

private String rideId: Transaction ID (e.g., "RIDE-8941").

private String userId: Foreign key reference to User.userId.

private String vehicleId: Foreign key reference to Vehicle.vehicleId.

private String pickupLocation: Origin point.

private String dropLocation: Destination point.

private double distanceKm: Route distance in kilometers.

private double totalFare: Final computed fare amount.

private RideStatus status: Current lifecycle state (RideStatus).

private long startTimeStamp: Epoch time of ride initiation.

private long endTimeStamp: Epoch time of ride completion.

Methods:

Constructor with parameter validation.

Getters and Setters for all transactional fields.

public String toString(): Formatted multi-line trip invoice sheet.

RideStatus.java (Enum)
Values:

REQUESTED: Initial state when user books.

ONGOING: Dispatched and currently executing.

COMPLETED: Terminal successful state; payment settled.

CANCELLED: Terminal aborted state; vehicle released.

2. Vehicle Specialization Hierarchy (com.quickride.model.vehicle)
Vehicle.java (Abstract Base Class)
Fields:

protected String vehicleId: Unique license / ID tag.

protected String plateNumber: Registration license number.

protected String modelName: Make & Model (e.g., "Honda City").

protected double baseRatePerKm: Base tariff charged per kilometer.

protected boolean isAvailable: Real-time dispatch readiness flag.

Methods:

public Vehicle(String vehicleId, String plateNumber, String modelName, double baseRatePerKm)

public abstract double calculateFare(double distanceKm): Contract method for polymorphic pricing .  
PDF
+ 1

public void setAvailable(boolean available): Updates fleet readiness flag.

public boolean isAvailable(): Availability getter.

Standard accessors & mutators.

Car.java (Extends Vehicle)
Additional Fields:

private int seatingCapacity: Max passenger limit (e.g., 4 or 6).

private boolean isAcAvailable: Flag indicating climate control support.

Behavior:

Overrides calculateFare(double distanceKm):

Total Fare=(baseRatePerKm×distanceKm)+(isAcAvailable ? 50.0:0.0)+Base Booking Fee
Overrides toString() to include AC and seat capacity tags.

Bike.java (Extends Vehicle)
Additional Fields:

private boolean helmetProvided: Safety compliance check.

Behavior:

Overrides calculateFare(double distanceKm):

Total Fare=max(Minimum Base Fare (e.g. 25.0),baseRatePerKm×distanceKm)
Overrides toString() to append pillion helmet details.

3. Repository / Data Access Layer (com.quickride.repository)
Acts as an isolated In-Memory persistence layer using thread-safe / standard Java Collections :  
PDF
+ 1

VehicleRepository.java
Internal Storage: private final Map<String, Vehicle> vehicleStorage = new HashMap<>()

Methods:

public void save(Vehicle vehicle): Persists or updates vehicle entity.

public Optional<Vehicle> findById(String vehicleId): Queries by primary ID.

public List<Vehicle> findAll(): Returns unmodifiable collection of total fleet.

public List<Vehicle> findAvailableVehicles(): Filters fleet matching isAvailable == true.

public boolean existsById(String vehicleId): Checks ID uniqueness.

UserRepository.java
Internal Storage: private final Map<String, User> userStorage = new HashMap<>()

Methods:

public void save(User user): Persists or updates user profile.

public Optional<User> findById(String userId): Look up by ID.

public Optional<User> findByPhoneNumber(String phone): Search by contact number.

public List<User> findAll(): Returns all registered passengers.

RideRepository.java
Internal Storage: private final Map<String, Ride> rideStorage = new HashMap<>()

Methods:

public void save(Ride ride): Logs trip record.

public Optional<Ride> findById(String rideId): Finds trip by transaction code.

public List<Ride> findByUserId(String userId): Collects trip audit trail for a rider.

public List<Ride> findAll(): Full ledger audit list.

4. Service / Business Logic Layer (com.quickride.service)
Handles domain rules, state validation, and transactional synchronization:

VehicleService.java
Dependencies: VehicleRepository

Methods:

public void registerVehicle(Vehicle vehicle): Validates ID unicity, stores to repo.

public List<Vehicle> getAvailableFleet(): Returns all dispatch-ready vehicles.

public Vehicle getVehicleOrThrow(String vehicleId): Throws EntityNotFoundException if ID is invalid.

public void setVehicleAvailability(String vehicleId, boolean status): Toggles lock state.

UserService.java
Dependencies: UserRepository

Methods:

public User registerUser(String id, String name, String phone, double initialBalance): Enforces validation rules.

public User getUserOrThrow(String userId): Retrieves user or throws EntityNotFoundException.

public void processWalletDeduction(String userId, double amount): Validates balance adequacy before charging.

RideService.java
Dependencies: RideRepository, VehicleService, UserService

Methods:

public Ride bookRide(String userId, String vehicleId, String pickup, String dest, double estDistanceKm):

Validates userId and vehicleId existence via services.

Validates vehicle is dispatch-ready (isAvailable == true), throws VehicleNotAvailableException if busy .  
PDF
+ 1

Calculates estimated upfront fare.

Marks vehicle isAvailable = false.

Creates Ride with status ONGOING and saves to RideRepository.

public Ride completeRide(String rideId):

Loads ride; verifies status is ONGOING.

Invokes polymorphic vehicle.calculateFare(distance) to finalize tariff.

Deducts fare from passenger wallet.

Releases vehicle: vehicle.setAvailable(true).

Sets ride.setStatus(RideStatus.COMPLETED) and updates repository.

public Ride cancelRide(String rideId):

Ensures ride is not already completed.

Releases assigned vehicle (isAvailable = true).

Sets status to RideStatus.CANCELLED.

public List<Ride> getUserRideHistory(String userId): Fetches booking log for rider.

5. Custom Exception Hierarchy (com.quickride.exception)
All custom application errors extend RuntimeException or Exception:

Exception Class	Throw Trigger Condition
EntityNotFoundException	When an invalid userId, vehicleId, or rideId is supplied to the service layer.
VehicleNotAvailableException	
Triggered if a ride is booked on a vehicle with isAvailable == false .  
PDF
+ 1

InvalidRideOperationException	Attempting invalid state transitions (e.g. completing a cancelled or already completed ride).
6. CLI Presentation Layer (com.quickride.MainApp)
Terminal UI driver encapsulating loop menus, input scanning, and presentation formatting.

Menu Actions:

[1] Register Rider Profile: Prompts Name, Phone, Wallet Balance.

[2] Onboard Fleet Vehicle: Select Vehicle Type (Car / Bike), enter Rates & Attributes.

[3] List Available Fleet: Pretty-prints tabular view of available vehicles.

[4] Book Ride: Takes Rider ID, Vehicle ID, Pickup/Drop & Distance, triggers dispatch.

[5] Complete Trip & Generate Invoice: Settles trip, charges wallet, marks car available.

[6] Cancel Active Ride: Aborts trip and unlocks vehicle.

[7] View Rider Trip History: Displays all completed/cancelled receipts for a user.

[0] Exit System: Gracefully exits with clean shutdown notice.

🔄 Data & Execution Flows
1. Ride Booking & Fare Calculation Sequence
Plaintext
[MainApp (CLI)]         [RideService]          [VehicleService]        [RideRepository]
       │                      │                       │                       │
       │─── bookRide(...) ───>│                       │                       │
       │                      │─── getVehicle() ─────>│                       │
       │                      │<── return Vehicle ────│                       │
       │                      │                                               │
       │                      │─── [Check Availability: true]                 │
       │                      │─── [calculateFare(distance)]                  │
       │                      │                                               │
       │                      │─── setAvailable(false)─> [Vehicle]            │
       │                      │                                               │
       │                      │─── save(new Ride(...)) ──────────────────────>│
       │<── Ride Ticket ──────│                                               │
2. Ride Status State Machine
Plaintext
       ┌───────────────┐
       │   REQUESTED   │
       └───────┬───────┘
               │ (Service dispatch)
               ▼
       ┌───────────────┐
  ┌───>│    ONGOING    │───┐
  │    └───────────────┘   │
  │ (Cancel)               │ (Complete Trip)
  ▼                        ▼
┌──────────────┐     ┌───────────────┐
│  CANCELLED   │     │   COMPLETED   │
│ (Terminal)   │     │  (Terminal)   │
└──────────────┘     └───────────────┘
📊 Class & Interface Interaction Matrix
Caller	Target Class / Interface	Interaction Type	Purpose
MainApp	RideService / VehicleService	Service Call	CLI delegation to core business logic
RideService	Vehicle (Polymorphic)	Method Invocation	
Runs dynamic calculateFare(km) formula   
PDF
+ 1

RideService	VehicleRepository	Query / Mutation	Locks & unlocks availability flags
RideService	RideRepository	CRUD Operation	Persists state across transaction lifecycle
VehicleService	VehicleRepository	CRUD Operation	Fleet queries & inventory management
UserService	UserRepository	CRUD Operation	User ledger checks & updates
💻 Compilation & CLI Execution
Execute from the root directory (QuickRide/):

Bash
# Step 1: Clean build directory
rm -rf bin && mkdir bin

# Step 2: Compile all source packages
javac -d bin src/com/quickride/model/vehicle/*.java \
            src/com/quickride/model/*.java \
            src/com/quickride/exception/*.java \
            src/com/quickride/repository/*.java \
            src/com/quickride/service/*.java \
            src/com/quickride/MainApp.java

# Step 3: Run the application
java -cp bin com.quickride.MainApp
"""

with open("README.md", "w") as f:
f.write(readme_pro)

print("Enterprise README.md generated successfully.")


```text?code_stdout&code_event_index=1
Enterprise README.md generated successfully.

Ek complete enterprise-grade aur 10x detailed README.md file ready kardi hai jisme code ke alawa har ek Field, Method, Class, Hierarchy, Sequence Flow, FSM State Machine, aur Architectural Map deep-detail me document kiya gaya hai:  
PDF
+ 2

Your Professional Enterprise README is ready:

MD icon
README
 MD 
Key Architectural Blueprints Included in README:
System Topology & 3-Tier Layering: Presentation (MainApp) → Service (Business Engine) → Repository (In-Memory State) → Domain Model (OOP Entities)[cite: 1, 3].

Exhaustive Domain Entity Specifications:

User.java: Private attributes, wallet debit/credit helper logic, identity coordinates.  
PDF
+ 1

Ride.java: Transaction metadata, foreign key mapping, timestamps, status flags.  
PDF
+ 1

RideStatus.java (Enum): Finite State Machine transitions (REQUESTED → ONGOING → COMPLETED / CANCELLED).  
PDF
+ 1

Polymorphic Specialization Breakdown:

Vehicle.java (Abstract base): Abstract contract calculateFare(distanceKm).  
PDF
+ 1

Car.java & Bike.java: Concrete overrides with dynamic mathematical formula mappings (AC surcharge, minimum fare caps).  
PDF
+ 1

Data Access & Storage Schema (Repository Layer): Exact method contracts (save, findById, findAvailableVehicles, findByUserId) over Java Collections (Map<String, T>).  
PDF
+ 1

Business Logic Engine (Service Layer): Step-by-step transaction validation, atomic vehicle locking/unlocking, fare resolution, and exception dispatching.  
PDF
+ 1

ASCII Sequence Diagram & State Lifecycle: Live visual map showing how a CLI request passes across services to update vehicle availability and ride ledgers.  
PDF
+ 2

Class Interaction Matrix & Custom Exceptions: Complete matrix mapping dependencies and error scenarios (EntityNotFoundException, VehicleNotAvailableException, InvalidRideOperationException).  
PDF
+ 1

Is file ko direct project ke root directory me README.md ke taur par save karke git commit aur push kar sakte ho.  
MD

readme me bna ke de

QuickRide — Enterprise-Grade Modular Mobility & Fare Engine
A decoupled, 3-tier Core Java reference architecture simulating on-demand ride dispatching, polymorphic dynamic fare engines, and transactional state lifecycle management.  
PDF
+ 2

Table of Contents
System Architecture & Design Topology

Folder & Package Blueprint

Component & Class Specifications

Model & Domain Entities

Vehicle Specialization Layer

Repository & In-Memory Persistence Layer

Service & Business Logic Engine

Custom Exception Hierarchy

CLI Presentation & Orchestration Layer

Data & Execution Flows

Ride Booking Flow (Sequence & State Machine)

Finite State Machine (FSM) Lifecycle

Class & Interface Interaction Matrix

Compilation & CLI Execution

🏛 System Architecture & Design Topology
QuickRide follows strict Separation of Concerns (SoC) structured across three decoupled layers:  
PDF
+ 2

Plaintext
┌────────────────────────────────────────────────────────┐
│             Presentation / Driver Layer                │
│         (MainApp.java - Scanner CLI / I/O)             │
└───────────────────────────┬────────────────────────────┘
                            │ Method Invocations / DTOs
                            ▼
┌────────────────────────────────────────────────────────┐
│             Service / Business Logic Layer             │
│   (UserService | VehicleService | RideService Engine)  │
└─────────────┬────────────────────────────┬─────────────┘
              │                            │
              ▼                            ▼
┌───────────────────────────┐ ┌──────────────────────────┐
│   Repository (In-Memory)  │ │      Domain Models       │
│  (Map / Collection State) │ │ (Vehicle, Car, Bike, Ride)│
└───────────────────────────┘ └──────────────────────────┘
📁 Folder & Package Blueprint
Plaintext
QuickRide/
├── docs/
│   ├── QuickRide_Assignment_Specification.pdf    # Complete specification & rubric handout
│   └── architecture_diagram.png                  # System block diagram
├── src/
│   └── com/
│       └── quickride/
│           │
│           ├── MainApp.java                      # Interactive CLI menu orchestrator
│           │
│           ├── model/                            # Pure domain entities (No business logic)
│           │   ├── User.java                     # Rider & passenger domain entity
│           │   ├── Ride.java                     # Booking transaction aggregate model
│           │   ├── RideStatus.java               # State transition enum
│           │   └── vehicle/                      # Vehicle abstraction hierarchy
│           │       ├── Vehicle.java              # Abstract base vehicle entity
│           │       ├── Car.java                  # Concrete sedan/hatchback entity
│           │       ├── Bike.java                 # Concrete two-wheeler entity
│           │       └── Auto.java                 # Concrete three-wheeler entity (optional)
│           │
│           ├── repository/                       # In-memory CRUD & collection lookups
│           │   ├── VehicleRepository.java        # Fleet inventory repository
│           │   ├── UserRepository.java           # User profile storage
│           │   └── RideRepository.java           # Transaction & ride registry
│           │
│           ├── service/                          # Transactional business logic
│           │   ├── VehicleService.java           # Fleet status, query & registration rules
│           │   ├── UserService.java              # User registration & wallet operations
│           │   └── RideService.java              # Dispatch algorithm, lifecycle & pricing
│           │
│           └── exception/                        # Checked & unchecked failure domain
│               ├── VehicleNotAvailableException.java
│               ├── InvalidRideOperationException.java
│               └── EntityNotFoundException.java
│
└── README.md
🧩 Component & Class Specifications
1. Model & Domain Entities (com.quickride.model)
User.java
Purpose: Encapsulates rider personal identity, contact coordinates, and prepaid ledger[cite: 4].

Fields:

private String userId: Unique identifier (e.g., "USR-101")[cite: 4].

private String fullName: Rider name[cite: 4].

private String phoneNumber: 10-digit contact number[cite: 4].

private double walletBalance: Prepaid monetary balance[cite: 4].

Methods:

public User(String userId, String fullName, String phoneNumber, double initialBalance)[cite: 4]

Getters & Setters for all attributes[cite: 4].

public void deductBalance(double amount): Decrements wallet balance[cite: 4].

public void creditBalance(double amount): Tops up wallet balance[cite: 4].

public String toString(): Formats user profile summary for console printing[cite: 4].

Ride.java
Purpose: Aggregate entity recording a booking transaction, location vector, and state metadata[cite: 1, 2, 4].

Fields:

private String rideId: Transaction ID (e.g., "RIDE-8941")[cite: 4].

private String userId: Foreign key reference to User.userId[cite: 4].

private String vehicleId: Foreign key reference to Vehicle.vehicleId[cite: 4].

private String pickupLocation: Origin point[cite: 4].

private String dropLocation: Destination point[cite: 4].

private double distanceKm: Route distance in kilometers[cite: 4].

private double totalFare: Final computed fare amount[cite: 4].

private RideStatus status: Current lifecycle state (RideStatus)[cite: 4].

private long startTimeStamp: Epoch time of ride initiation[cite: 4].

private long endTimeStamp: Epoch time of ride completion[cite: 4].

Methods:

Constructor with parameter validation[cite: 4].

Getters and Setters for all transactional fields[cite: 4].

public String toString(): Formatted multi-line trip invoice sheet[cite: 4].

RideStatus.java (Enum)
Values:

REQUESTED: Initial state when user books[cite: 4].

ONGOING: Dispatched and currently executing[cite: 4].

COMPLETED: Terminal successful state; payment settled[cite: 4].

CANCELLED: Terminal aborted state; vehicle released[cite: 4].

2. Vehicle Specialization Hierarchy (com.quickride.model.vehicle)
Vehicle.java (Abstract Base Class)
Fields:

protected String vehicleId: Unique license / ID tag[cite: 4].

protected String plateNumber: Registration license number[cite: 4].

protected String modelName: Make & Model (e.g., "Honda City")[cite: 4].

protected double baseRatePerKm: Base tariff charged per kilometer[cite: 4].

protected boolean isAvailable: Real-time dispatch readiness flag[cite: 4].

Methods:

public Vehicle(String vehicleId, String plateNumber, String modelName, double baseRatePerKm)[cite: 4]

public abstract double calculateFare(double distanceKm): Contract method for polymorphic pricing[cite: 1, 2, 4].

public void setAvailable(boolean available): Updates fleet readiness flag[cite: 4].

public boolean isAvailable(): Availability getter[cite: 4].

Standard accessors & mutators[cite: 4].

Car.java (Extends Vehicle)
Additional Fields:

private int seatingCapacity: Max passenger limit (e.g., 4 or 6)[cite: 4].

private boolean isAcAvailable: Flag indicating climate control support[cite: 4].

Behavior:

Overrides calculateFare(double distanceKm):

Total Fare=(baseRatePerKm×distanceKm)+(isAcAvailable ? 50.0:0.0)+Base Booking Fee
[cite: 4]

Overrides toString() to include AC and seat capacity tags[cite: 4].

Bike.java (Extends Vehicle)
Additional Fields:

private boolean helmetProvided: Safety compliance check[cite: 4].

Behavior:

Overrides calculateFare(double distanceKm):

Total Fare=max(Minimum Base Fare (e.g. 25.0),baseRatePerKm×distanceKm)
[cite: 4]

Overrides toString() to append pillion helmet details[cite: 4].

3. Repository / Data Access Layer (com.quickride.repository)
Acts as an isolated in-memory persistence layer using Java Collections[cite: 1, 2, 4]:

VehicleRepository.java
Internal Storage: private final Map<String, Vehicle> vehicleStorage = new HashMap<>()[cite: 4]

Methods:

public void save(Vehicle vehicle): Persists or updates vehicle entity[cite: 4].

public Optional<Vehicle> findById(String vehicleId): Queries by primary ID[cite: 4].

public List<Vehicle> findAll(): Returns unmodifiable collection of total fleet[cite: 4].

public List<Vehicle> findAvailableVehicles(): Filters fleet matching isAvailable == true[cite: 4].

public boolean existsById(String vehicleId): Checks ID uniqueness[cite: 4].

UserRepository.java
Internal Storage: private final Map<String, User> userStorage = new HashMap<>()[cite: 4]

Methods:

public void save(User user): Persists or updates user profile[cite: 4].

public Optional<User> findById(String userId): Look up by ID[cite: 4].

public Optional<User> findByPhoneNumber(String phone): Search by contact number[cite: 4].

public List<User> findAll(): Returns all registered passengers[cite: 4].

RideRepository.java
Internal Storage: private final Map<String, Ride> rideStorage = new HashMap<>()[cite: 4]

Methods:

public void save(Ride ride): Logs trip record[cite: 4].

public Optional<Ride> findById(String rideId): Finds trip by transaction code[cite: 4].

public List<Ride> findByUserId(String userId): Collects trip audit trail for a rider[cite: 4].

public List<Ride> findAll(): Full ledger audit list[cite: 4].

4. Service / Business Logic Layer (com.quickride.service)
Handles domain rules, state validation, and transactional synchronization[cite: 4]:

VehicleService.java
Dependencies: VehicleRepository[cite: 4]

Methods:

public void registerVehicle(Vehicle vehicle): Validates ID unicity, stores to repo[cite: 4].

public List<Vehicle> getAvailableFleet(): Returns all dispatch-ready vehicles[cite: 4].

public Vehicle getVehicleOrThrow(String vehicleId): Throws EntityNotFoundException if ID is invalid[cite: 4].

public void setVehicleAvailability(String vehicleId, boolean status): Toggles lock state[cite: 4].

UserService.java
Dependencies: UserRepository[cite: 4]

Methods:

public User registerUser(String id, String name, String phone, double initialBalance): Enforces validation rules[cite: 4].

public User getUserOrThrow(String userId): Retrieves user or throws EntityNotFoundException[cite: 4].

public void processWalletDeduction(String userId, double amount): Validates balance adequacy before charging[cite: 4].

RideService.java
Dependencies: RideRepository, VehicleService, UserService[cite: 4]

Methods:

public Ride bookRide(String userId, String vehicleId, String pickup, String dest, double estDistanceKm):

Validates userId and vehicleId existence via services[cite: 4].

Validates vehicle is dispatch-ready (isAvailable == true), throws VehicleNotAvailableException if busy[cite: 1, 2, 4].

Calculates estimated upfront fare[cite: 4].

Marks vehicle isAvailable = false[cite: 4].

Creates Ride with status ONGOING and saves to RideRepository[cite: 4].

public Ride completeRide(String rideId):

Loads ride; verifies status is ONGOING[cite: 4].

Invokes polymorphic vehicle.calculateFare(distance) to finalize tariff[cite: 4].

Deducts fare from passenger wallet[cite: 4].

Releases vehicle: vehicle.setAvailable(true)[cite: 4].

Sets ride.setStatus(RideStatus.COMPLETED) and updates repository[cite: 4].

public Ride cancelRide(String rideId):

Ensures ride is not already completed[cite: 4].

Releases assigned vehicle (isAvailable = true)[cite: 4].

Sets status to RideStatus.CANCELLED[cite: 4].

public List<Ride> getUserRideHistory(String userId): Fetches booking log for rider[cite: 4].

5. Custom Exception Hierarchy (com.quickride.exception)
Exception Class	Throw Trigger Condition
EntityNotFoundException	When an invalid userId, vehicleId, or rideId is supplied to the service layer[cite: 4].
VehicleNotAvailableException	Triggered if a ride is booked on a vehicle with isAvailable == false[cite: 1, 2, 4].
InvalidRideOperationException	Attempting invalid state transitions (e.g. completing a cancelled or already completed ride)[cite: 4].
6. CLI Presentation Layer (com.quickride.MainApp)
Terminal UI driver encapsulating loop menus, input scanning, and presentation formatting[cite: 4]:

Menu Actions:

[1] Register Rider Profile: Prompts Name, Phone, Wallet Balance[cite: 4].

[2] Onboard Fleet Vehicle: Select Vehicle Type (Car / Bike), enter Rates & Attributes[cite: 4].

[3] List Available Fleet: Pretty-prints tabular view of available vehicles[cite: 4].

[4] Book Ride: Takes Rider ID, Vehicle ID, Pickup/Drop & Distance, triggers dispatch[cite: 4].

[5] Complete Trip & Generate Invoice: Settles trip, charges wallet, marks car available[cite: 4].

[6] Cancel Active Ride: Aborts trip and unlocks vehicle[cite: 4].

[7] View Rider Trip History: Displays all completed/cancelled receipts for a user[cite: 4].

[0] Exit System: Gracefully exits with clean shutdown notice[cite: 4].

🔄 Data & Execution Flows
1. Ride Booking & Fare Calculation Sequence
Plaintext
[MainApp (CLI)]         [RideService]          [VehicleService]        [RideRepository]
       │                      │                       │                       │
       │─── bookRide(...) ───>│                       │                       │
       │                      │─── getVehicle() ─────>│                       │
       │                      │<── return Vehicle ────│                       │
       │                      │                                               │
       │                      │─── [Check Availability: true]                 │
       │                      │─── [calculateFare(distance)]                  │
       │                      │                                               │
       │                      │─── setAvailable(false)─> [Vehicle]            │
       │                      │                                               │
       │                      │─── save(new Ride(...)) ──────────────────────>│
       │<── Ride Ticket ──────│                                               │
2. Ride Status State Machine
Plaintext
       ┌───────────────┐
       │   REQUESTED   │
       └───────┬───────┘
               │ (Service dispatch)
               ▼
       ┌───────────────┐
  ┌───>│    ONGOING    │───┐
  │    └───────────────┘   │
  │ (Cancel)               │ (Complete Trip)
  ▼                        ▼
┌──────────────┐     ┌───────────────┐
│  CANCELLED   │     │   COMPLETED   │
│ (Terminal)   │     │  (Terminal)   │
└──────────────┘     └───────────────┘
📊 Class & Interface Interaction Matrix
Caller	Target Class / Interface	Interaction Type	Purpose
MainApp	RideService / VehicleService	Service Call	CLI delegation to core business logic[cite: 4]
RideService	Vehicle (Polymorphic)	Method Invocation	Runs dynamic calculateFare(km) formula[cite: 1, 2, 4]
RideService	VehicleRepository	Query / Mutation	Locks & unlocks availability flags[cite: 4]
RideService	RideRepository	CRUD Operation	Persists state across transaction lifecycle[cite: 4]
VehicleService	VehicleRepository	CRUD Operation	Fleet queries & inventory management[cite: 4]
UserService	UserRepository	CRUD Operation	User ledger checks & updates[cite: 4]
💻 Compilation & CLI Execution
Execute from the root directory (QuickRide/):

Bash
# Step 1: Clean build directory
rm -rf bin && mkdir bin

# Step 2: Compile all source packages
javac -d bin src/com/quickride/model/vehicle/*.java \
            src/com/quickride/model/*.java \
            src/com/quickride/exception/*.java \
            src/com/quickride/repository/*.java \
            src/com/quickride/service/*.java \
            src/com/quickride/MainApp.java

# Step 3: Run the application
java -cp bin com.quickride.MainApp



Gemini is AI and can make mistakes.

# QuickRide — Enterprise-Grade Modular Mobility & Fare Engine

> A decoupled, 3-tier Core Java reference architecture simulating on-demand ride dispatching, polymorphic dynamic fare engines, and transactional state lifecycle management [cite: 1, 3].

---

## Table of Contents
1. [System Architecture & Design Topology](#-system-architecture--design-topology)
2. [Folder & Package Blueprint](#-folder--package-blueprint)
3. [Component & Class Specifications](#-component--class-specifications)
   - [Model & Domain Entities](#1-model--domain-entities-comquickridemodel)
   - [Vehicle Specialization Layer](#2-vehicle-specialization-hierarchy-comquickridemodelvehicle)
   - [Repository & In-Memory Persistence Layer](#3-repository--data-access-layer-comquickriderepository)
   - [Service & Business Logic Engine](#4-service--business-logic-layer-comquickrideservice)
   - [Custom Exception Hierarchy](#5-custom-exception-hierarchy-comquickrideexception)
   - [CLI Presentation & Orchestration Layer](#6-cli-presentation-layer-comquickridemainapp)
4. [Data & Execution Flows](#-data--execution-flows)
   - [Ride Booking Flow (Sequence & State Machine)](#1-ride-booking--fare-calculation-sequence)
   - [Finite State Machine (FSM) Lifecycle](#2-ride-status-state-machine)
5. [Class & Interface Interaction Matrix](#-class--interface-interaction-matrix)
6. [Compilation & CLI Execution](#-compilation--cli-execution)

---

## 🏛 System Architecture & Design Topology

QuickRide follows strict **Separation of Concerns (SoC)** structured across three decoupled layers [cite: 1, 3]:

```text
┌────────────────────────────────────────────────────────┐
│             Presentation / Driver Layer                │
│         (MainApp.java - Scanner CLI / I/O)             │
└───────────────────────────┬────────────────────────────┘
                            │ Method Invocations / DTOs
                            ▼
┌────────────────────────────────────────────────────────┐
│             Service / Business Logic Layer             │
│   (UserService | VehicleService | RideService Engine)  │
└─────────────┬────────────────────────────┬─────────────┘
              │                            │
              ▼                            ▼
┌───────────────────────────┐ ┌──────────────────────────┐
│   Repository (In-Memory)  │ │      Domain Models       │
│  (Map / Collection State) │ │ (Vehicle, Car, Bike, Ride)│
└───────────────────────────┘ └──────────────────────────┘
```

---

## 📁 Folder & Package Blueprint

```text
QuickRide/
├── docs/
│   ├── QuickRide_Assignment_Specification.pdf    # Complete specification & rubric handout
│   └── architecture_diagram.png                  # System block diagram
├── src/
│   └── com/
│       └── quickride/
│           │
│           ├── MainApp.java                      # Interactive CLI menu orchestrator
│           │
│           ├── model/                            # Pure domain entities (No business logic)
│           │   ├── User.java                     # Rider & passenger domain entity
│           │   ├── Ride.java                     # Booking transaction aggregate model
│           │   ├── RideStatus.java               # State transition enum
│           │   └── vehicle/                      # Vehicle abstraction hierarchy
│           │       ├── Vehicle.java              # Abstract base vehicle entity
│           │       ├── Car.java                  # Concrete sedan/hatchback entity
│           │       ├── Bike.java                 # Concrete two-wheeler entity
│           │       └── Auto.java                 # Concrete three-wheeler entity (optional)
│           │
│           ├── repository/                       # In-memory CRUD & collection lookups
│           │   ├── VehicleRepository.java        # Fleet inventory repository
│           │   ├── UserRepository.java           # User profile storage
│           │   └── RideRepository.java           # Transaction & ride registry
│           │
│           ├── service/                          # Transactional business logic
│           │   ├── VehicleService.java           # Fleet status, query & registration rules
│           │   ├── UserService.java              # User registration & wallet operations
│           │   └── RideService.java              # Dispatch algorithm, lifecycle & pricing
│           │
│           └── exception/                        # Checked & unchecked failure domain
│               ├── VehicleNotAvailableException.java
│               ├── InvalidRideOperationException.java
│               └── EntityNotFoundException.java
│
└── README.md
```

---

## 🧩 Component & Class Specifications

### 1. Model & Domain Entities (`com.quickride.model`)

#### `User.java`
* **Purpose**: Encapsulates rider personal identity, contact coordinates, and prepaid ledger.
* **Fields**:
  * `private String userId`: Unique identifier (e.g., `"USR-101"`).
  * `private String fullName`: Rider name.
  * `private String phoneNumber`: 10-digit contact number.
  * `private double walletBalance`: Prepaid monetary balance.
* **Methods**:
  * `public User(String userId, String fullName, String phoneNumber, double initialBalance)`
  * Getters & Setters for all attributes.
  * `public void deductBalance(double amount)`: Decrements wallet balance.
  * `public void creditBalance(double amount)`: Tops up wallet balance.
  * `public String toString()`: Formats user profile summary for console printing.

#### `Ride.java`
* **Purpose**: Aggregate entity recording a booking transaction, location vector, and state metadata [cite: 1, 2].
* **Fields**:
  * `private String rideId`: Transaction ID (e.g., `"RIDE-8941"`).
  * `private String userId`: Foreign key reference to `User.userId`.
  * `private String vehicleId`: Foreign key reference to `Vehicle.vehicleId`.
  * `private String pickupLocation`: Origin point.
  * `private String dropLocation`: Destination point.
  * `private double distanceKm`: Route distance in kilometers.
  * `private double totalFare`: Final computed fare amount.
  * `private RideStatus status`: Current lifecycle state (`RideStatus`).
  * `private long startTimeStamp`: Epoch time of ride initiation.
  * `private long endTimeStamp`: Epoch time of ride completion.
* **Methods**:
  * Constructor with parameter validation.
  * Getters and Setters for all transactional fields.
  * `public String toString()`: Formatted multi-line trip invoice sheet.

#### `RideStatus.java` *(Enum)*
* **Values**:
  * `REQUESTED`: Initial state when user books.
  * `ONGOING`: Dispatched and currently executing.
  * `COMPLETED`: Terminal successful state; payment settled.
  * `CANCELLED`: Terminal aborted state; vehicle released.

---

### 2. Vehicle Specialization Hierarchy (`com.quickride.model.vehicle`)

#### `Vehicle.java` *(Abstract Base Class)*
* **Fields**:
  * `protected String vehicleId`: Unique license / ID tag.
  * `protected String plateNumber`: Registration license number.
  * `protected String modelName`: Make & Model (e.g., `"Honda City"`).
  * `protected double baseRatePerKm`: Base tariff charged per kilometer.
  * `protected boolean isAvailable`: Real-time dispatch readiness flag.
* **Methods**:
  * `public Vehicle(String vehicleId, String plateNumber, String modelName, double baseRatePerKm)`
  * `public abstract double calculateFare(double distanceKm)`: Contract method for polymorphic pricing [cite: 1, 2].
  * `public void setAvailable(boolean available)`: Updates fleet readiness flag.
  * `public boolean isAvailable()`: Availability getter.
  * Standard accessors & mutators.

#### `Car.java` *(Extends `Vehicle`)*
* **Additional Fields**:
  * `private int seatingCapacity`: Max passenger limit (e.g., 4 or 6).
  * `private boolean isAcAvailable`: Flag indicating climate control support.
* **Behavior**:
  * Overrides `calculateFare(double distanceKm)`:
    $$	ext{Total Fare} = (	ext{baseRatePerKm} 	imes 	ext{distanceKm}) + (	ext{isAcAvailable} \ ? \ 50.0 : 0.0) + 	ext{Base Booking Fee}$$
  * Overrides `toString()` to include AC and seat capacity tags.

#### `Bike.java` *(Extends `Vehicle`)*
* **Additional Fields**:
  * `private boolean helmetProvided`: Safety compliance check.
* **Behavior**:
  * Overrides `calculateFare(double distanceKm)`:
    $$	ext{Total Fare} = \max(	ext{Minimum Base Fare (e.g. 25.0)}, 	ext{baseRatePerKm} 	imes 	ext{distanceKm})$$
  * Overrides `toString()` to append pillion helmet details.

---

### 3. Repository / Data Access Layer (`com.quickride.repository`)

Acts as an isolated In-Memory persistence layer using thread-safe / standard Java Collections [cite: 1, 2]:

#### `VehicleRepository.java`
* **Internal Storage**: `private final Map<String, Vehicle> vehicleStorage = new HashMap<>()`
* **Methods**:
  * `public void save(Vehicle vehicle)`: Persists or updates vehicle entity.
  * `public Optional<Vehicle> findById(String vehicleId)`: Queries by primary ID.
  * `public List<Vehicle> findAll()`: Returns unmodifiable collection of total fleet.
  * `public List<Vehicle> findAvailableVehicles()`: Filters fleet matching `isAvailable == true`.
  * `public boolean existsById(String vehicleId)`: Checks ID uniqueness.

#### `UserRepository.java`
* **Internal Storage**: `private final Map<String, User> userStorage = new HashMap<>()`
* **Methods**:
  * `public void save(User user)`: Persists or updates user profile.
  * `public Optional<User> findById(String userId)`: Look up by ID.
  * `public Optional<User> findByPhoneNumber(String phone)`: Search by contact number.
  * `public List<User> findAll()`: Returns all registered passengers.

#### `RideRepository.java`
* **Internal Storage**: `private final Map<String, Ride> rideStorage = new HashMap<>()`
* **Methods**:
  * `public void save(Ride ride)`: Logs trip record.
  * `public Optional<Ride> findById(String rideId)`: Finds trip by transaction code.
  * `public List<Ride> findByUserId(String userId)`: Collects trip audit trail for a rider.
  * `public List<Ride> findAll()`: Full ledger audit list.

---

### 4. Service / Business Logic Layer (`com.quickride.service`)

Handles domain rules, state validation, and transactional synchronization:

#### `VehicleService.java`
* **Dependencies**: `VehicleRepository`
* **Methods**:
  * `public void registerVehicle(Vehicle vehicle)`: Validates ID unicity, stores to repo.
  * `public List<Vehicle> getAvailableFleet()`: Returns all dispatch-ready vehicles.
  * `public Vehicle getVehicleOrThrow(String vehicleId)`: Throws `EntityNotFoundException` if ID is invalid.
  * `public void setVehicleAvailability(String vehicleId, boolean status)`: Toggles lock state.

#### `UserService.java`
* **Dependencies**: `UserRepository`
* **Methods**:
  * `public User registerUser(String id, String name, String phone, double initialBalance)`: Enforces validation rules.
  * `public User getUserOrThrow(String userId)`: Retrieves user or throws `EntityNotFoundException`.
  * `public void processWalletDeduction(String userId, double amount)`: Validates balance adequacy before charging.

#### `RideService.java`
* **Dependencies**: `RideRepository`, `VehicleService`, `UserService`
* **Methods**:
  * `public Ride bookRide(String userId, String vehicleId, String pickup, String dest, double estDistanceKm)`:
    1. Validates `userId` and `vehicleId` existence via services.
    2. Validates vehicle is dispatch-ready (`isAvailable == true`), throws `VehicleNotAvailableException` if busy [cite: 1, 2].
    3. Calculates estimated upfront fare.
    4. Marks vehicle `isAvailable = false`.
    5. Creates `Ride` with status `ONGOING` and saves to `RideRepository`.
  * `public Ride completeRide(String rideId)`:
    1. Loads ride; verifies status is `ONGOING`.
    2. Invokes polymorphic `vehicle.calculateFare(distance)` to finalize tariff.
    3. Deducts fare from passenger wallet.
    4. Releases vehicle: `vehicle.setAvailable(true)`.
    5. Sets `ride.setStatus(RideStatus.COMPLETED)` and updates repository.
  * `public Ride cancelRide(String rideId)`:
    1. Ensures ride is not already completed.
    2. Releases assigned vehicle (`isAvailable = true`).
    3. Sets status to `RideStatus.CANCELLED`.
  * `public List<Ride> getUserRideHistory(String userId)`: Fetches booking log for rider.

---

### 5. Custom Exception Hierarchy (`com.quickride.exception`)

All custom application errors extend `RuntimeException` or `Exception`:

| Exception Class | Throw Trigger Condition |
| :--- | :--- |
| `EntityNotFoundException` | When an invalid `userId`, `vehicleId`, or `rideId` is supplied to the service layer. |
| `VehicleNotAvailableException` | Triggered if a ride is booked on a vehicle with `isAvailable == false` [cite: 1, 2]. |
| `InvalidRideOperationException` | Attempting invalid state transitions (e.g. completing a cancelled or already completed ride). |

---

### 6. CLI Presentation Layer (`com.quickride.MainApp`)

Terminal UI driver encapsulating loop menus, input scanning, and presentation formatting.

* **Menu Actions**:
  1. `[1] Register Rider Profile`: Prompts Name, Phone, Wallet Balance.
  2. `[2] Onboard Fleet Vehicle`: Select Vehicle Type (Car / Bike), enter Rates & Attributes.
  3. `[3] List Available Fleet`: Pretty-prints tabular view of available vehicles.
  4. `[4] Book Ride`: Takes Rider ID, Vehicle ID, Pickup/Drop & Distance, triggers dispatch.
  5. `[5] Complete Trip & Generate Invoice`: Settles trip, charges wallet, marks car available.
  6. `[6] Cancel Active Ride`: Aborts trip and unlocks vehicle.
  7. `[7] View Rider Trip History`: Displays all completed/cancelled receipts for a user.
  8. `[0] Exit System`: Gracefully exits with clean shutdown notice.

---

## 🔄 Data & Execution Flows

### 1. Ride Booking & Fare Calculation Sequence

```text
[MainApp (CLI)]         [RideService]          [VehicleService]        [RideRepository]
       │                      │                       │                       │
       │─── bookRide(...) ───>│                       │                       │
       │                      │─── getVehicle() ─────>│                       │
       │                      │<── return Vehicle ────│                       │
       │                      │                                               │
       │                      │─── [Check Availability: true]                 │
       │                      │─── [calculateFare(distance)]                  │
       │                      │                                               │
       │                      │─── setAvailable(false)─> [Vehicle]            │
       │                      │                                               │
       │                      │─── save(new Ride(...)) ──────────────────────>│
       │<── Ride Ticket ──────│                                               │
```

---

### 2. Ride Status State Machine

```text
       ┌───────────────┐
       │   REQUESTED   │
       └───────┬───────┘
               │ (Service dispatch)
               ▼
       ┌───────────────┐
  ┌───>│    ONGOING    │───┐
  │    └───────────────┘   │
  │ (Cancel)               │ (Complete Trip)
  ▼                        ▼
┌──────────────┐     ┌───────────────┐
│  CANCELLED   │     │   COMPLETED   │
│ (Terminal)   │     │  (Terminal)   │
└──────────────┘     └───────────────┘
```

---

## 📊 Class & Interface Interaction Matrix

| Caller | Target Class / Interface | Interaction Type | Purpose |
| :--- | :--- | :--- | :--- |
| `MainApp` | `RideService` / `VehicleService` | Service Call | CLI delegation to core business logic |
| `RideService` | `Vehicle` *(Polymorphic)* | Method Invocation | Runs dynamic `calculateFare(km)` formula [cite: 1, 2] |
| `RideService` | `VehicleRepository` | Query / Mutation | Locks & unlocks availability flags |
| `RideService` | `RideRepository` | CRUD Operation | Persists state across transaction lifecycle |
| `VehicleService`| `VehicleRepository` | CRUD Operation | Fleet queries & inventory management |
| `UserService` | `UserRepository` | CRUD Operation | User ledger checks & updates |

---

## 💻 Compilation & CLI Execution

Execute from the root directory (`QuickRide/`):

```bash
# Step 1: Clean build directory
rm -rf bin && mkdir bin

# Step 2: Compile all source packages
javac -d bin src/com/quickride/model/vehicle/*.java             src/com/quickride/model/*.java             src/com/quickride/exception/*.java             src/com/quickride/repository/*.java             src/com/quickride/service/*.java             src/com/quickride/MainApp.java

# Step 3: Run the application
java -cp bin com.quickride.MainApp
```
README.md
Displaying README.md.