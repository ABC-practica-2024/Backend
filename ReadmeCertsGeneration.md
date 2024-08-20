# Public/Private Keys

**<span style="color:red">Please ensure that you have OpenSSL installed on your machine.</span>**

1. **First command** – generates the private key:
   ```bash
   openssl genrsa -out keypair.pem 2048
   ```

2. **Second command** - generates the public key associated with the private key:
   ```bash
   openssl rsa -in keypair.pem -pubout -out public.pem
   ```

3. **Third command** – generates a private key that is recognized by Spring. Spring supports only `.pkcs8` private keys:
   ```bash
   openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
   ```

4. After this, you can delete the `keypair.pem`.

5. Copy the keys into the `resources/certs` directory.
