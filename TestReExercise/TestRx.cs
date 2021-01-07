using System;
using com.hanlin.ReExercise;
using NUnit.Framework;

namespace TestReExercise
{
    public class TestRx
    {
        private IInternetValidator validator;
        
        [SetUp]
        public void Setup()
        {
            validator = new InternetValidator();
        }

        [Test]
        public void TestUrl_Nullability()
        {
            String targetUrl = null;
            
            bool validatedResult = validator.IsValidUrl(targetUrl);
            Assert.False(validatedResult);
        }
        
        [Test]
        public void TestUrl_Empty()
        {
            String targetUrl = String.Empty;
            
            bool validatedResult = validator.IsValidUrl(targetUrl);
            Assert.False(validatedResult);
        }

        [TestCase("http://www.hle.com.tw")]
        [TestCase("https://www.hle.com.tw")]
        [TestCase("https://testbank.hle.com.tw:8080")]
        [TestCase("http://testbank.hle.com.tw:8080/home")]
        [TestCase("https://www.hle.com.tw:80001/home/domain/")]
        [TestCase("https://www.hle.com.tw:80001/home/cp/calendar?subject=ch&year=50")]
        [TestCase("http://localhost:8080")]
        public void TestUrl_Http(String targetUrl)
        {
            bool validatedResult = validator.IsValidUrl(targetUrl); 
            Assert.True(validatedResult);
        }

        [Test]
        public void TestEmail_Null()
        {
            String targetAddress = null;
            
            bool validatedResult = validator.IsValidUrl(targetAddress);
            Assert.False(validatedResult);            
        }

        [Test]
        public void TestEmail_Empty()
        {
            String targetAddress = String.Empty;
            
            bool validatedResult = validator.IsValidUrl(targetAddress);
            Assert.False(validatedResult);             
        }

        [TestCase("tom@gmail.com")]
        [TestCase("jason.chen@hanlin.com.tw")]
        [TestCase("jane@microsoft.com.tw")]
        public void TestEmail_Address(String targetAddress)
        {
            bool validatedResult = validator.IsValidUrl(targetAddress);
            Assert.True(validatedResult);              
        }
    }
}