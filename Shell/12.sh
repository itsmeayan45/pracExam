#!/bin/bash

while true; do
    echo "=================================================="
    echo "               MAIN MENU"
    echo "=================================================="
    echo "1. List files in current directory with permissions"
    echo "2. List of user Processes"
    echo "3. Today's date (dd-Month YYYY)"
    echo "4. List of users in the system (Currently logged in)"
    echo "5. Exit"
    echo "=================================================="
    
    # Read user input without a newline prompt for better UX
    read -p "Enter your choice (1-5): " choice
    echo "" # Print a blank line for spacing

    case $choice in
        1)
            echo "--- Files and Permissions ---"
            # 'ls -l' lists files in long format (showing permissions)
            ls -l
            ;;
        2)
            echo "--- User Processes ---"
            # 'ps -u $USER' lists processes for the current user
            # 'less' is often used for long lists, but we will use standard output here
            ps -u "$USER"
            ;;
        3)
            echo "--- Today's Date ---"
            # %d = day, %B = Full Month Name, %Y = Year
            date "+%d-%B %Y"
            ;;
        4)
            echo "--- Users Currently Logged In ---"
            # 'who' lists logged in users. 
            # If you want ALL system users (including system accounts), 
            # replace 'who' with: cut -d: -f1 /etc/passwd
            who
            ;;
        5)
            echo "Exiting program. Goodbye!"
            exit 0
            ;;
        *)
            echo "Invalid option. Please enter a number between 1 and 5."
            ;;
    esac

    echo "" # Add spacing before the menu reappears
    read -p "Press Enter to continue..." # Pause so user can read output
done