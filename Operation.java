import java.io.*;
import java.util.*;

public class Operation {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);

        char fl;
        do { 
            int choice = 0;
            String filePath = null;
            String folderPath = null;
            String fileName = null;
            String fileContent = null;
            File file = null;
            boolean success = false;
            try {
                System.out.println("File Operations");
                System.out.println("1. Create a new folder");
                System.out.println("2. Create a new text file");
                System.out.println("3. Write into a text file");
                System.out.println("4. Append data to a text file");
                System.out.println("5. Rename a file");
                System.out.println("6. Delete a file");
                System.out.print("Please enter the Menu: ");
                choice =sc.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.println("Please enter the Folder-name to be Created: ");
                        String foldername=sc.next();
                        
                        System.out.println("Enter the folder path: ");
                        folderPath = sc.next();
                        String fi=folderPath+foldername;
                        success = new File(fi).mkdir();
                        if (success) {
                            System.out.println(" created successfully.");
                        } else {
                            System.out.println(" creation failed.");
                        }
                        break;
                    
                    case 2:
                        System.out.println("Enter the folder path: ");
                        folderPath = sc.next();
                        System.out.println("Enter the file name: ");
                        fileName = sc.next();
                        System.out.println(folderPath);
                        file = new File(folderPath + File.separator + fileName+".txt");
                        success = file.createNewFile();
                        if (success) {
                            System.out.println(" created successfully.");
                        } else {
                            System.out.println(" creation failed.");
                        }
                        break;
                        
                    case 3:
                        System.out.println("Enter the file path: ");
                        filePath = sc.next();
                        System.out.println("Enter the file content: ");
                        fileContent = sc.next();
                        FileWriter writer = new FileWriter(filePath);
                        writer.write(fileContent);
                        writer.close();
                        System.out.println("Content was succesfully loaded");
                        break;
                        
                    case 4:
                        System.out.println("Enter the file path: ");
                        filePath = sc.next();
                        System.out.println("Enter the file content to append: ");
                        fileContent = sc.next();
                        FileWriter appendWriter = new FileWriter(filePath, true);
                        appendWriter.write(fileContent);
                        appendWriter.close();
                        System.out.println("Content appended to the file successfully.");
                        break;
                        
                    case 5:
                        System.out.println("Enter the file path: ");
                        filePath = sc.next();
                        System.out.println("Enter the new file name: ");
                        fileName = sc.next();
                        File newFile = new File(filePath);
                        success = newFile.renameTo(new File(newFile.getParent() + File.separator + fileName));
                        if (success) {
                            System.out.println(" renamed successfully.");
                        } else {
                            System.out.println(" renaming failed.");
                        }
                        break;
                        
                    case 6:
                        System.out.println("Enter the file path: ");
                        filePath = sc.next();
                        file = new File(filePath);
                        success = file.delete();
                        if (success) {
                            System.out.println(" deleted successfully.");
                        } else {
                            System.out.println(" deletion failed.");
                        }
                        break;
                        
                    default:
                        System.out.println("Wrong option");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                            System.out.println("Wrong option");
        } catch (SecurityException e) {
            System.out.println("exception occurred. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.print("Press 'Y' to go to operations");
        fl=sc.next().charAt(0);
    }while(fl=='y'||fl=='Y');
  
}
}