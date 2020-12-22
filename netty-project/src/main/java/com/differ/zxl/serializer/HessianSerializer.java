package com.differ.zxl.serializer;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.differ.zxl.exception.JKYConfigServiceException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HessianSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(os);
        try {
            ho.writeObject(obj);
            ho.flush();
            byte[] result = os.toByteArray();
            return result;
        } catch (IOException e) {
            throw new JKYConfigServiceException(e);
        } finally {
            try {
                ho.close();
            } catch (IOException e) {
                throw new JKYConfigServiceException(e);
            }
            try {
                os.close();
            } catch (IOException e) {
                throw new JKYConfigServiceException(e);
            }
        }
    }

    @Override
    public <T> Object deserialize(byte[] bytes, Class<T> clazz) {
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        Hessian2Input hi = new Hessian2Input(is);
        try {
            Object result = hi.readObject();
            return result;
        } catch (IOException e) {
            throw new JKYConfigServiceException(e);
        } finally {
            try {
                hi.close();
            } catch (Exception e) {
                throw new JKYConfigServiceException(e);
            }
            try {
                is.close();
            } catch (IOException e) {
                throw new JKYConfigServiceException(e);
            }
        }
    }
}
