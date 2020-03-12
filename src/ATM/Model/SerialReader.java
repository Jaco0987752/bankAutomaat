package Model;

/*
*   https://fazecast.github.io/jSerialComm/
*/

import com.fazecast.jSerialComm.*;

public class SerialReader {

   public SerialReader (){
      startListerning();
   }

   private void startListerning(){
      SerialPort comPort = SerialPort.getCommPorts()[0];
      comPort.openPort();
      comPort.addDataListener(new SerialPortDataListener() {
         @Override
         public int getListeningEvents() {
            return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
         }

         @Override
         public void serialEvent(SerialPortEvent event) {
            if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
               return;
            byte[] newData = new byte[comPort.bytesAvailable()];
            int numRead = comPort.readBytes(newData, newData.length);
            System.out.println("Read " + numRead + " bytes.");
            System.out.println(new String(newData));
         }
      });
   }
}