# Medi-Vision

An intelligent system to help common man via easing the process of getting health checkups remotely and maintaing prescribed drugs usage. We've also try to regulate the waiting queue at receptions in hospitals, and have also tried to reach out to Big Data sector. Several health checkups have been made available with the help of **Computer Vision**.

> We'll be explaining our tech stack and use of each below.

## Tech Stack

1. OpenCV (Python Server providing OpenCV Cloud services)
2. Android
3. RestDB.io

## Computer Vision (OpenCV)

1. Breathing rate and heart rate monitoring from your live feed. (accurate upto 90%)
2. Checking for cancer from a snapshot of patch on skin. (accurate upto 70-80% without ML !)

## RestDB.io

1. Handle data of patients.
2. Patient's past medical history and some other details are used for data plotting and providing helpful models for others.

## Android App

1. Has a reminder feature to remind patients of taking prescribed drugs dosage on time.
2. When a patient gets in a hospital, the static data is automatically filled in his E-form, and all he/she has to do is, fill the other details (reason/disease etc etc) in it. This data is then submitted to the doctor and our RestDB server as well.
3. Uses rtsp to stream live feed to the OpenCV cloud for making health services available remotely.

> Now that all the things have been explained separately, let's integrate all of them and explain you the workflow

## Workflow

![](https://ibin.co/3GijlemN45hU.png)

When a person has a checkup via android app, the details of the checkup are stored in RestDB. This data is accessible by doctors so that when patient visits a doctor,

1. He/She doesn't has to carry reports
2. Suppose patient fills hyper tension in e-form(mentioned above), we'll automatically update the doctor with heart beat monitoring data collected over time when the patiend had checkups. This can be very useful for both.
3. The same data can be used to generate certain medical models.

## More details on OpenCV part

1. Live Feed Analysis
    * Heart Rate monitoring - Taken help from http://github.com/mossblaser/HeartMonitor and http://github.com/brycedrennan/eulerian-magnification. Research Paper (there are many) - https://people.csail.mit.edu/mrub/papers/vidmag.pdf
    So what it does => By focussing on forehead, when averaging over the green channel light intensity, one can estimate the heartbeat of a person.
    * Breath Rate monitoring - Using the LK Algorithm for optic flow, certain points on user's chest are tracked simultaneously and the breath rate is approximated by movement of chest, the diaphragm in and out.

2. Skin Cancer Detection
    * Research Paper implemented - http://www.ijser.in/archives/v3i6/IJSER15287.pdf
    * This paper follows the ABCD rule to detect chances of a lesion turning into cancer (read the paper for more details)

> Read the papers for mathematical caluclations explanations
