Part 1 : Tech Support Chain of Responsibility
This project demonstrates the Chain of Responsibility pattern for handling tech support requests. Requests are processed by different support levels, and each level decides whether to handle the issue or escalate it.

Handlers:
FAQBotHandler: Handles simple issues like password reset.

JuniorSupportHandler: Handles refund requests and billing issues.

SeniorSupportHandler: Handles account bans and data loss.

Part 2 : Smart Home Remote Control (Command Pattern)
This is an example implementation of the Command Design Pattern for controlling smart devices like lights and thermostats in a smart home system.

Features:
Command Interface: Defines execute() and undo() methods for each command.

Receiver Classes: Includes devices like Light and Thermostat, which perform actual actions.

Concrete Command Classes: Commands like TurnOnLight and SetTemp encapsulate actions for the devices.

Invoker (Remote): Stores and triggers commands through a Map of slots, and supports undo functionality.

