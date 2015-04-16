package com.util;

import java.io.*;

public final class ObjectSerializer {

	/**
     * 將物件陣列轉換為byte array.
     * @param obj
     * @return
     * @throws IOException
     */
    public static byte[] serializeToByteArray (Object obj)
        throws IOException
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            byte[] bytes = bos.toByteArray();
            return bytes;
        } catch (IOException e) {
            throw e;
        } finally {
            if (out != null)
                out.close();
            if (bos != null)
                bos.close();
        }
    }

    /**
     * 將byte array回轉成為物件陣列. 
     * 
     * @param bytes
     * @return 
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deserializeToObject (byte[] bytes)
        throws IOException, ClassNotFoundException
    {
        ObjectInputStream is = null;
        ObjectInput in = null;
        try {
            is = new ObjectInputStream( new ByteArrayInputStream (bytes) );
            Object o = is.readObject();
            return o;
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            try { if (is != null) is.close(); } catch (IOException e) {}
            try { if (in != null) in.close(); } catch (IOException e) {}
        }
    }
	
}
