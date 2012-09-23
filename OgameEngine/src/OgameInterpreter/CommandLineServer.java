/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameInterpreter;

import OgameEngine.Exceptions.OgameException;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author plich
 */
public class CommandLineServer implements Runnable {

    public CommandLineServer(InterpreteServer server) {
        this.server = server;
    }

    String read() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(System.in);
        DataInputStream dis = new DataInputStream(bis);
        String s = (String) JOptionPane.showInputDialog("Podaj polecenie");
        dis.close();
        bis.close();
        return s;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String s = read();
                server.parse(s);
            } catch (NullPointerException ex){
                this.server.close();
                break;
            } 
            catch (ParseException ex) {
                Logger.getLogger(CommandLineServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CommandLineServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private InterpreteServer server;
    
    public static void main(String[] args0) throws OgameException, InterruptedException{
        InterpreteServer server = new InterpreteServer();
        CommandLineServer commandLine = new CommandLineServer(server);
        Thread t1 = new Thread(server);
        t1.start();
        Thread t2 = new Thread(commandLine);
        t2.start();
        t1.join();
        t2.join();
    } 
}
