package widaas.cidaas.rajanarayanan.myandroidlibrary;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import static android.content.ContentValues.TAG;

public class AndroidCidaas {

    private static final int RC_SIGN_IN = 100;
    String getClass;
    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;

    Activity activityGlobal;

    public String getGetClass()
    {
        getClass="Cidaas Widas";
        return getClass;
    }


    public AndroidCidaas(Activity activity)
    {

      gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

      activityGlobal=activity;

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(activity, gso);


    }


    public  void  getLoginDetails()
    {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(activityGlobal);

        if(account!=null)
        {
            Toast.makeText(activityGlobal, "succcess"+account.getDisplayName(), Toast.LENGTH_SHORT).show();
        }
        else
        {


            signIn();
        }
    }


    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        activityGlobal.startActivityForResult(signInIntent, RC_SIGN_IN);
    }




    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }


    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            Toast.makeText(activityGlobal, "succcess"+account.getDisplayName(), Toast.LENGTH_SHORT).show();
           // updateUI(account);
        } catch (ApiException e) {

            Toast.makeText(activityGlobal, "Error", Toast.LENGTH_SHORT).show();
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }


}
