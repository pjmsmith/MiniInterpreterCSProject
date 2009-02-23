package mainpack;

/**
 * Thanks to Bill Hess for providing this code.
 * Bill also cited http://www.javaworld.com/javaworld/jw-12-2000/jw-1229-traps.html
 *
 * This file might get modified as needed.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Command {

    public static int exec(String command) {
        int exitVal = -1;

        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(command);

            StreamGobbler errorGobbler = new StreamGobbler (proc.getErrorStream(), "ERR");
            StreamGobbler outputGobbler = new StreamGobbler (proc.getInputStream(), "OUT");
            errorGobbler.start();
            outputGobbler.start();

            exitVal = proc.waitFor();

            errorGobbler.join();
            outputGobbler.join();
        } catch (Throwable e) {
            e.printStackTrace();
        }

         return exitVal;
     }

    static class StreamGobbler extends Thread {
        InputStream is;
        String type;

        StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while ( (line = br.readLine()) != null)
                  System.out.println(type + ">" + line);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}

