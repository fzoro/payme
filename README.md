1. Create account
2. Create an app
3. Get Access Token: https://developer.paypal.com/docs/api/overview/#make-your-first-call
```
curl -v https://api.sandbox.paypal.com/v1/oauth2/token \
    -H "Accept: application/json" \
    -H "Accept-Language: en_US" \
    -u "client_id:secret" \
    -d "grant_type=client_credentials"
```