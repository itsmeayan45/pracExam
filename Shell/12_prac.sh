while true; do
    echo "Enter your choices:---"
    echo "1. List of files in my current directory with their permissions"
    echo "2. List of User Process"
    echo "3. Today's Date (dd-December 2025)"
    echo "4. List of users in the System"
    echo "5. Exit"
    echo "============================================="

    read -p "Enter your choice " choice
    echo ""
    case $choice in
        1)
            echo "files and permissions: "
            ls -la
            ;;
        2)
            echo "List of user process:"
            ps -u "$USER"
            ;;
        3)
            echo "Today's date: "
            date "+%d-%B %Y"
            ;;
        4)
            echo "Users currently logged in:"
            whoami
            ;;
        5)
            echo "Exiting program...."
            exit 0
            ;;
        *)
            echo "Invalid Choice"
            ;;
    esac
    echo ""
    echo -p "Press Enter to continue----"
done