using System;

namespace com.hanlin.ReExercise
{
    public interface IInternetValidator
    {
        bool IsValidUrl(String url);
        bool IsValidEmail(String email);
    }
}