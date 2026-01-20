- [CS 1632 - Software Quality Assurance](#cs-1632---software-quality-assurance)
  * [Description](#description)
  * [Test Application: CatScale](#test-application-catscale)
  * [Creating a Test Plan](#creating-a-test-plan)
  * [Creating a Traceability Matrix](#creating-a-traceability-matrix)
  * [Reporting Defects](#reporting-defects)
    + [Components of a Defect Report](#components-of-a-defect-report)
    + [GitHub Bug Tracking System](#github-bug-tracking-system)
  * [Submission](#submission)

# CS 1632 - Software Quality Assurance
Spring Semester 2026 - Exercise 1

* DUE: January 27 (Tuesday), 2026 before start of class

**GitHub Classroom Link:** https://classroom.github.com/a/gV5wEUIa

# Description

For this exercise, you will create a **test plan** for the CatScale
application, based on the [requirements](requirements.md) listed.  You are
asked to fill out the test plan on the provided [report
template](ReportTemplate.docx).  You will document test cases using the
template provided in the [Creating a Test Plan](#creating-a-test-plan) section.  
You are also expected to find at least **three defects** in the system (you
will be able to find more if you apply the empirical methods based on
equivalence classes discussed in class).  Please report and resolve them
through the GitHub issues tracking system, as explained in the [GitHub Bug
Tracking System](#github-bug-tracking-system) section.

## Test Application: CatScale

CatScale is a simple Java application that tells you whether your cat is
overweight, underweight, or just right.  The application is provided in the
form of a JAR file (CatScale.jar) without the source code, so you will be doing
**black box testing**.  You can run the program using the following
commandline:

```
java -jar CatScale.jar
```

Feel free to do some **exploratory testing** to get a feel for the application.  

## Creating a Test Plan

Please beware of the **pitfalls** mentioned in the [Test Plans
Lecture](https://github.com/wonsunahn/CS1632_Spring2026/blob/main/lectures/CS1632_Lecture4_Test_Plans.pdf).

Create a test plan based on the [requirements](requirements.md).  How many test
cases do you need?  Enough to satisfy the following requirements (no pun intended).

1. Each requirement needs at least one test case testing it (for good test
coverage), Remember, for a test case to cover a requirement, the postconditions
of the test must verify that requirement.  The traceability matrix that you
submit as part of the test plan should show that all requirements are covered.

1. For each requirement, make sure you cover all behaviors associated with that
requirement.  That means you will have to choose a value from each
**equivalence class** to test.

1. Make sure you have at least one base case, one edge case, and one corner
case in the mix of test cases.  You will explain for each of these why they can
be categorized as such in the report.

Please use the following template for test cases:

```
IDENTIFIER: [A unique label (e.g. TEST-INVALID-NAME-20-ALPHABETS)]
TEST CASE: [A description of what this test case is testing]
PRECONDITIONS: [State of the system before performing execution steps]
EXECUTION STEPS: [Step-by-step numbered instructions on how to perform test]
POSTCONDITIONS: [*EXPECTED* state of the system after having performed execution steps]
```

A few hints about how to write preconditions, execution steps, and
postconditions so that the test case is **repeatable**:

* PRECONDITIONS: The program we will be testing today is a commandline Java
program (java -jar CatScale.jar).  We need to list everything that can
potentially impact the behavior of the test.  What are they?  The presence of
java (JRE) and, of course, the CatScale.jar file itself.  So, something like
the following.

  ```
  PRECONDITIONS:
     - "java -version" shows java version "11.0.21".
     - CatScale.jar file is in the current directory.
  ```

  Note that the Java version is specified precisely.  This is important because
the versions of software installations may impact system behavior as well.  It
is common practice to duplicate the same test case for multiple versions, to
ensure portability.

* EXECUTION STEPS: Steps should be numbered so that they are easy to follow.
Steps should also be precise and leave no room for interpretation so that tests
are repeatable.

* POSTCONDITIONS: Postconditions are expected behavior given the preconditions
and execution steps, and should be derived based on the requirements.  They are
the correctness criteria that your system is tested against and should
introduce neither false positive or false negative defects.  Again, please
refer to the pitfalls discussed in the lecture.

## Creating a Traceability Matrix

A traceability matrix allows us to correlate test cases to requirements and
vice versa.  It allows us to check how much testing a particular requirement is
receiving (forward traceability).  It also allows us to check why a test case
is being run (backward traceability).  

Note that a postcondition check of a test cases may test several requirements
at once.  This is only natural.  Hence, you can have one test case mapped to
multiple requirements.  However, if one test case is testing multiple
requirements, you need to ask yourself if the test case is merging multiple
test scenarios that are better separated into multiple test cases (Pitfall 5).
A simple check to see if you fell into this pitfall is asking yourself whether
the postconditions are checking some state that is generated in the middle of
the execution steps rather than at the end (they are called **post**conditions
after all).  This indicates that you are performing additional execution steps
beyond a postcondition check that should really belong to another test case.

## Reporting Defects

Please find **at least three defects** and report them through the GitHub issues system.  

### Components of a Defect Report

Please use the following template for defects reporting:

```
IDENTIFIER: [A unique label (e.g. BUG-DISPLAY-VERDICT)]
SUMMARY: [A one sentence description of defect]
DESCRIPTION: [A detailed description of everything the tester discovered]
REPRODUCTION STEPS: [Preconditions + Steps to reproduce (similar to test case execution steps)]
EXPECTED BEHAVIOR: [What you expected according to requirements]
OBSERVED BEHAVIOR: [What you *ACTUALLY* saw]
```

A few hints on how to fill in reproduction steps, expected behavior, and
observed behavior so that the defect is **reproducible**.

* REPRODUCTION STEPS should start with preconditions, if there is no separate
entry for preconditions as in this case.  You will not be able to reproduce the
bug even if you reproduce the steps if you start from a different precondition!  For example:

  ```
  REPRODUCTION STEPS:
     Preconditions:
     - "java -version" shows java version "11.0.21".
     - CatScale.jar file is in the current directory.
     Steps:
     1. ...
     2. ...
  ```

* EXPECTED BEHAVIOR is literally what it says.  If you discovered this defect
while running a test case, it would look very similar to the POSTCONDITIONS of
the test case.  Please do not justify why you think this is the expected
behavior as it is irrelevant and only serves to confuse the reader.

* OBSERVED BEHAVIOR is arguably the most important component of a defect report.
You should describe what you observed with as much detail as possible so that
developers can use that information to debug.  Screenshots of your application
output or webpage are highly encouraged since that is the best way to convey
what you see.  If your application crashed, don't just say it crashed --- that
is not going to be very helpful.  Include all the output the program displayed
while crashing, for example an exception stack trace if you are testing a Java
program.  

### GitHub Bug Tracking System

To get hands on experience in defect reporting, tracking, and resolution, you
are going to use the GitHub issue management system.

On your GitHub classroom repository, Click on the "Issues" tab on the top.
Initially you should have 0 open issues.  Click on the "New issue" button on
the top right.  Fill the comment box with the defect report properly formatted
with the 6 items shown above.  For the title, use the content of the SUMMARY
item.  When all is filled in, click on the "Submit new issue" button.  

After the issue is submitted, perform **triage** and tag the issue as a "bug"
and assign it to yourself, as shown below in the first red box:

<img alt="Issues list" src=img/open_issue.png>

Now if you click on the "Issues" tab, you should see the new open issue:

<img alt="Issues list" src=img/issues_list.png>

Now, it is time to resolve the issue.  Have the assignee for the issue open the
issue by clicking on it, and then have her click the "Create a branch" link
shown in the second red box above.  This will create a new **git branch** to work
on the issue.  Once you are done creating the branch, you should see it appear
on the issue page (see red box):

<img alt="create branch" src=img/create_branch.png>

Now click on the branch name (in this case,
"1-when-42-is-passed-as-the-number-of-times...").  That would take you to the
newly created branch as below:

<img alt="open branch" src=img/open_branch.png>

Make sure that the branch selector indicates the newly created issue branch,
not the main branch, as seen in the red box above.  Now, we were doing black
box testing, so we do not have access to the source code.  So, we are going to
resolve this issue by sneakily adding a new requirement to the requirements
specification, and then claim that this is a feature, not a bug.  Navigate to
the requirements.md file and add the new requirement as shown below in the red
box: 

<img alt="edit requirement" src=img/edit_requirement.png>

Go ahread and commit the change to the issue branch.  Now that we are done with
our fix, we are going to create a **pull request**, which is a request to pull
the changes in the issue branch into the main branch.  One or more people can
review that request and make sure everything is kosher before pulling
everything into the main branch, because updating the main branch comes with
risks.  Create the pull request by clicking on the "Pull requests" tab and
clicking on the "New pull request" button as showin in the red box below:

<img alt="create pull request" src=img/create_pull_request.png>

In the ensuing page, select the issue branch as the source branch as indicated
in the red box below:

<img alt="compare changes" src=img/compare_changes.png>

You can review the changes that will be pulled into the main branch as a result
of this pull request in green color.  If you are satisfied, go ahead and cluck
on the "Create pull request" button.  If you follow through, you will see the
new pull request created as seen below:

<img alt="merge pull request" src=img/merge_pull_request.png>

You can see that the issue branch has no merge conflicts with the main branch,
and that you have the option to add one or more reviewers before merging.  If
you had a CI (Continuous Integration) pipeline, then automated testing would
typically be performed on the issue branch at this point, but that will come
later in the semester. :)  for now, we are happy to merge the branch.  Click on
the "Merge pull request" button to do so.  Go ahead and confirm the merge when
prompted to do so.  You will see the pull request now successfully merged and
closed as you see below:

<img alt="merge pull request" src=img/merge_pull_request.png>

Delete the branch by clicking on the "Delete branch" button since you no longer
need the branch since it is already merged.  Closing the pull request will
automatically close the issue associated with that pull request, so that when
you click on the "Issues" tab, you will no longer see any open issues.  Now you
need to click on the "Closed" issues tab indcated by the red box below to see
the closed issue:

<img alt="closed issue" src=img/closed_issue.png>

Now, as you may have guessed, the above defect is a bogus defect.  Please find
three real defects, open issues for them, and close them using the process
above, by modifying the requirements to turn the bugs into features.  Of
course, in a real world scenario, you would most likely modify the source code,
not the requirements, but the process would be the same.

## Submission

You will submit a short report that includes the test plan that you created as
well as a link to your GitHub issues for the defects.  Please use the
[ReportTemplate.docx](ReportTemplate.docx) file provided in this directory to
write your report.  If you don't have a .docx compatible word processor, that's
perfectly fine as long as you follow the same organization.  A PDF version of
the file is at [ReportTemplate.pdf](ReportTemplate.pdf).

When you submit, please make sure that the introduction, traceability matrix,
test cases, and defects are on seperate pages.  You will be submitting to
GradeScope in PDF format.  When you submit, you will be asked to assign pages
in the PDF file to each rubric item.

When your exercise is marked as graded, you should find feedback written on
your grade details.  Please use the feedback wisely when doing Deliverable 1!

