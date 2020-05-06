# JAVADatabase
#
# The Application is about a Card game having 3 different kinds of Cards
# All Cards have a specific cost, and here below are the 3 types of Cards :
# 
# - Field Cards:
# 	--> defines the place where the fights are handled
#	--> they are defined by :
#		* their color (fixed defined color)
#		* their manaNbr of points
#
# - Creature Cards:
#	--> They are the one that can handle the fights
#	--> they are defined by :
#		* their name
#		* the number of damage points they can generate
#		* the number of life points they have or can give (to another creature)
#
#- Curse Cards: 
#	--> Allow a creature to cast a spell against another creature
#	--> They are defined by :
#		* their name
#		* the description of the spell and how it works
#
# We can apply different types of method (pick up a card/ play a card/display card game)
#
# This Application was developp with 3 ways :
#	- No Database access : use of a simple linkList to store the card game
#	- Database using JDBC (use of Connection, Prepared Statement and DAO interfaces)
#	- Database using JPA-Hibernate (Still with DAO, but working with Entities (entity and factory manager + dependencies libraries)
#	- Databse using SpringBoot (Using the POST/GET/PUT/DELETE commands using REST (H2 tests/no PostGRES yet)
#
#  

